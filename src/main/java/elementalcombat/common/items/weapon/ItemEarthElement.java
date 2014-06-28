package elementalcombat.common.items.weapon;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import elementalcombat.common.entity.element.earth.EntityBlock;
import elementalcombat.common.items.ItemElemental;

public class ItemEarthElement extends ItemElemental
{

	public ItemEarthElement(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10)
	{
		par3World.spawnEntityInWorld(new EntityBlock(par3World, par4, par5 + 1, par6));
		return true;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("THis is earth");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer)
	{
		System.out.println("Helm  pjflj");
		return par1ItemStack;
	}

}
