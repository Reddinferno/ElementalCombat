package elementalcombat.common.items.weapon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import elementalcombat.common.items.ItemElemental;

public class ItemWaterElement extends ItemElemental
{

	public ItemWaterElement(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) 
	{
		return itemstack;
	}
}
