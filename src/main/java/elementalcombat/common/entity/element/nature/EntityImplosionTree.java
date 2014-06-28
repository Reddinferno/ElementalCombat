package elementalcombat.common.entity.element.nature;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityImplosionTree extends EntityElement
{

	public EntityImplosionTree(World world)
	{
		super(world);
	}
	
	public EntityImplosionTree(World world, Entity entity)
	{
		super(world);
		setSize(1.95F, 0.55F);	
		posX -= MathHelper.cos((rotationYaw / 180F) * (float)Math.PI) * 0.16F;
		posY -= 0.10000000149011611D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * (float)Math.PI) * 0.16F;
		setPosition(posX, posY, posZ);
	}

	@Override
	public void onEntityUpdate()
	{
		System.out.println("This entity has been spawned: EntityImplostionTree");
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
		return 10;
	}

}
