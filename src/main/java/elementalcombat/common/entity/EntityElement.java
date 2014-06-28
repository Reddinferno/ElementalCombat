package elementalcombat.common.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityElement extends EntityThrowable
{
	private int xTile = -1;
	private int yTile = -1;
	private int zTile = -1;
	private int ticksInAir;
	private Block block;

	public int minRate = 0;

	public EntityElement(World world)
	{
		super(world);
	}

	public EntityElement(World world, EntityLivingBase player)
	{
		super(world, player);
		setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
		posX -= MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * 0.16F;
		posY -= 0.10000000149011611D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * 0.16F;
		setPositionAndRotation(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
		yOffset = 0.0F;
		motionX = -MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * MathHelper.cos((rotationPitch / 180F) * (float)Math.PI);
		motionZ = MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * MathHelper.cos((rotationPitch / 180F) * (float)Math.PI);
		motionY = -MathHelper.sin((rotationPitch / 180F) * (float)Math.PI);
		setThrowableHeading(motionX, motionY, motionZ, (speedMotion()) / 10.0F, 1.0F);
	}

	public EntityElement(World world, EntityLivingBase player, double d)
	{
		super(world, player);
		setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
		posX -= MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * 0.16F * d;
		posY -= 0.10000000149011611D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * 0.16F * d;
		setPosition(posX, posY, posZ);
		yOffset = 0.0F;
		motionX = -MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * MathHelper.cos((rotationPitch / 180F) * (float)Math.PI);
		motionZ = MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * MathHelper.cos((rotationPitch / 180F) * (float)Math.PI);
		motionY = -MathHelper.sin((rotationPitch / 180F) * (float)Math.PI);
		setThrowableHeading(motionX, motionY, motionZ, (speedMotion()) / 10.0F, 1.0F);
	}
	
	@SuppressWarnings("rawtypes")
	public void onUpdate()
	{
		this.lastTickPosX = this.posX;
		this.lastTickPosY = this.posY;
		this.lastTickPosZ = this.posZ;
		super.onUpdate();
		onEntityUpdate();
		if (minRate++ > maxLife() * 10) 
		{
			setDead();
		}

		if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
		{
			float f = MathHelper.sin((float)(motionX * motionX + motionZ * motionZ));
			prevRotationYaw = rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / Math.PI);
			prevRotationPitch = rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / Math.PI);
		}

		if (this.throwableShake > 0)
		{
			--this.throwableShake;
		}

		if (this.inGround)
		{
			if (this.worldObj.getBlock(this.xTile, this.yTile, this.zTile) == this.block)
			{
				blockImpact(worldObj, xTile, yTile, zTile);
				return;
			}

			this.inGround = false;
			this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
			this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
			this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
			this.ticksInAir = 0;
		}
		else
		{
			++this.ticksInAir;
		}

		Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
		Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition mop = this.worldObj.rayTraceBlocks(vec3, vec31);
		vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
		vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

		if (mop != null)
		{
			vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(mop.hitVec.xCoord, mop.hitVec.yCoord, mop.hitVec.zCoord);
		}

		if (!this.worldObj.isRemote)
		{
			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			EntityLivingBase entitylivingbase = this.getThrower();

			for (int j = 0; j < list.size(); ++j)
			{
				Entity entity1 = (Entity)list.get(j);

				if (entity1.canBeCollidedWith() && (entity1 != entitylivingbase || this.ticksInAir >= 5))
				{
					float f = 0.3F;
					AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
					MovingObjectPosition mop1 = axisalignedbb.calculateIntercept(vec3, vec31);

					if (mop1 != null)
					{
						double d1 = vec3.distanceTo(mop1.hitVec);

						if (d1 < d0 || d0 == 0.0D)
						{
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}

			if (entity != null)
			{
				mop = new MovingObjectPosition(entity);
			}
		}

		if (mop != null)
		{
			if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.worldObj.getBlock(mop.blockX, mop.blockY, mop.blockZ) == Blocks.portal)
			{
				this.setInPortal();
			}
			else
			{
				this.onImpact(mop);
			}
		}

		posX += motionX;
		posY += motionY;
		posZ += motionZ;

		float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

		for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f1) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
		{
			;
		}

		while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
		{
			this.prevRotationPitch += 360.0F;
		}

		while (this.rotationYaw - this.prevRotationYaw < -180.0F)
		{
			this.prevRotationYaw -= 360.0F;
		}

		while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
		{
			this.prevRotationYaw += 360.0F;
		}

		rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
		rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
		float f3 = 0.99F;
//		float f5 = gravityMotion() / 100.0F;

		if (isInWater())
		{
			waterImpact(worldObj, xTile, yTile, zTile);
		}

		motionX *= f3;
		motionY *= f3;
		motionZ *= f3;
//		motionY -= f5;
		setPositionAndRotation(posX, posY, posZ, rotationYaw, rotationPitch);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		if (mop.entityHit != null)
		{
			entityImpact(mop.entityHit);
		}
		if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
		{
			xTile = mop.blockX;
			yTile = mop.blockY;
			zTile = mop.blockZ;
			if (worldObj.blockExists(xTile, yTile, zTile))
			{
				blockImpact(worldObj, xTile, yTile + 1, zTile);
			}
		}
	}
	
	@Override
	protected float getGravityVelocity()
	{
		return gravityMotion() / 100.0F;
	}

	/**
	 * 
	 */
	public abstract void onEntityUpdate();

	public abstract void entityImpact(Entity entity);

	public abstract void blockImpact(World world, int x, int y, int z);

	public abstract void waterImpact(World world, int x, int y, int z);

	public abstract float speedMotion();

	public abstract float gravityMotion();

	public abstract int maxLife();

}
