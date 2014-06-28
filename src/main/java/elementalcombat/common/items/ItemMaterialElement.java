package elementalcombat.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class ItemMaterialElement extends Item
{
	public ItemMaterialElement()
	{
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
