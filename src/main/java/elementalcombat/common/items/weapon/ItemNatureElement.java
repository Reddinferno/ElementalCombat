package elementalcombat.common.items.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import elementalcombat.common.entity.element.nature.EntityImplosionDetection;
import elementalcombat.common.items.ItemElemental;

public class ItemNatureElement extends ItemElemental
{

	public ItemNatureElement(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer)
	{
		par2World.spawnEntityInWorld(new EntityImplosionDetection(par2World, par3EntityPlayer));
		return par1ItemStack;
	}

}
