package elementalcombat.common.entity.element.earth;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityRockThrow extends EntityElement
{

	public EntityRockThrow(World world)
	{
		super(world);
	}

	public EntityRockThrow(World world, EntityLivingBase player)
	{
		super(world, player);
	}

	public EntityRockThrow(World world, EntityLivingBase player, double d)
	{
		super(world, player, d);
	}

	@Override
	public void onEntityUpdate()
	{
		
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
