package elementalcombat.common.entity.element.air;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityCyclone extends EntityElement
{
	public EntityCyclone(World world)
	{
		super(world);
	}	
		
	public EntityCyclone(World world, EntityPlayer player)
	{
		super(world);
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
