package elementalcombat.common.entity.element.lightning;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityLightning extends EntityElement
{
	private MovingObjectPosition mop;
	EntityPlayer player;
	private int tick = 0;

	public EntityLightning(World world)
	{
		super(world);
	}
	
	public EntityLightning(World world, EntityPlayer player, float par3)
	{
		super(world);
		this.player = player;
		setLocationAndAngles(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
	}
	
	@Override
	public void onEntityUpdate()
	{
		super.onUpdate();
		this.tick += 1;
		Vec3 localVec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
		Vec3 localVec32 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		this.mop = this.worldObj.rayTraceBlocks(localVec31, localVec32);
		localVec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
		localVec32 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		if (this.mop != null) {
			localVec32 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.mop.hitVec.xCoord, this.mop.hitVec.yCoord, this.mop.hitVec.zCoord);
		}
		Entity localObject1 = null;
		List<?> localList = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(2.0D, 2.0D, 2.0D));
		double d1 = 0.0D;
		Iterator<?> localIterator = localList.iterator();
		Object localObject2;
		if (!this.worldObj.isRemote) 
		{
			while (localIterator.hasNext())
			{
				Entity localEntity = (Entity)localIterator.next();
				if ((localEntity.canBeCollidedWith()) && ((localEntity != player) || (this.tick >= 5)))
				{
					float f = 1.0F;
					localObject2 = localEntity.boundingBox.expand(f, f, f);
					MovingObjectPosition localMovingObjectPosition = ((AxisAlignedBB)localObject2).calculateIntercept(localVec31, localVec32);
					if (localMovingObjectPosition != null)
					{
						double d2 = localVec31.distanceTo(localMovingObjectPosition.hitVec);
						if ((d2 < d1) || (d1 == 0.0D))
						{
							localObject1 = localEntity;
							d1 = d2;
						}
					}
				}
			}
		}
		if (localObject1 != null) 
		{
			this.mop = new MovingObjectPosition(localObject1);
		}
		if (this.mop != null)
		{
			if (this.mop.typeOfHit == MovingObjectType.BLOCK)
			{
				setDead();
			}
			else
			{
				this.mop.entityHit.attackEntityFrom(DamageSource.generic, 20 / ((int)this.mop.entityHit.getDistanceToEntity(player) + 1));
			}
		}
		setDead();
	}

	@Override
	public void entityImpact(Entity entity)
	{
	}

	@Override
	public void blockImpact(World world, int x, int y, int z)
	{
	}

	@Override
	public void waterImpact(World world, int x, int y, int z)
	{
	}

	@Override
	public float speedMotion()
	{
		return 0;
	}

	@Override
	public float gravityMotion()
	{
		return 0;
	}

	@Override
	public int maxLife()
	{
		return 0;
	}

}
