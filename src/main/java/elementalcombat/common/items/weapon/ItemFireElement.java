package elementalcombat.common.items.weapon;

import elementalcombat.common.items.ItemElemental;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemFireElement extends ItemElemental
{

	public ItemFireElement(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}
	
	
	
	
}
