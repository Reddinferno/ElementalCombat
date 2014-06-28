package elementalcombat.common.entity.element.nature;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityImplosionDetection extends EntityElement
{

	public EntityImplosionDetection(World world)
	{
		super(world);
	}

	public EntityImplosionDetection(World world, EntityLivingBase player)
	{
		super(world, player);
		setSize(0.95F, 0.95F);
		posY -= 1.0D;
	}

	public EntityImplosionDetection(World world, EntityLivingBase player, double d)
	{
		super(world, player, d);
	}

	@Override
	public void onEntityUpdate()
	{
		double dist = 1.0D;
		AxisAlignedBB aa = boundingBox.expand(dist, 1.0D, dist);
		List<Entity> list = worldObj.getEntitiesWithinAABB(EntityLiving.class, aa);
		//		int i = MathHelper.floor_double(this.posX);
		//		int j = MathHelper.floor_double(this.posY - 1);
		//		int k = MathHelper.floor_double(this.posZ);
		//		Block block = this.worldObj.getBlock(i, j, k);
		//		for (int a = 0; a < 15; a++)
		//		{
		//			this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
		//		}

		for (Entity e : list) 
		{
				if (!worldObj.isRemote) 
				{
					e.motionY += 1.0D;
					worldObj.spawnEntityInWorld(new EntityImplosionTree(worldObj, this));
					this.setDead();
				}
		}

	}

	@Override
	public void entityImpact(Entity entity)
	{
	}

	@Override
	public void blockImpact(World world, int x, int y, int z)
	{
		setDead();
	}

	@Override
	public void waterImpact(World world, int x, int y, int z)
	{
		setDead();
	}

	@Override
	public float speedMotion()
	{
		return 1;
	}

	@Override
	public float gravityMotion()
	{
		return 0;
	}

	@Override
	public int maxLife()
	{
		return 10;
	}

}
