package elementalcombat.common.entity.element.lightning;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityLightningHelper extends EntityElement
{
	public Random rand;
	public Long lon;

	public EntityLightningHelper(World world)
	{
		super(world);
		ignoreFrustumCheck = true;
	}
	
	public EntityLightningHelper(World world, EntityPlayer player, double d)
	{
		super(world);
		setLocationAndAngles(player.posX, player.posY + player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);

	}
	
	public boolean isInRangeToRenderVec3D(Vec3 paramVec3)
	{
		return true;
	}

	public boolean isInRangeToRenderDist(double paramDouble)
	{
		return true;
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
