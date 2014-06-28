package elementalcombat.common.items;

import java.util.List;

import elementalcombat.common.lib.ModWeapons;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemElemental extends ItemSword
{
	private int selectedElement;
	protected int firstElement = 0;
	protected int secondElement = 1;
	protected int thirdElement = 2;
	
	public ItemElemental(ToolMaterial material)
	{
		super(material);
	}

	@Override
	public void onCreated(ItemStack itemstack, World world,
			EntityPlayer player)
	{
		itemstack.stackTagCompound.setString("master", player.getCommandSenderName());
		itemstack.stackTagCompound.setInteger("selection", selectedElement);
		itemstack.stackTagCompound.setInteger("firstElement", firstElement);
		itemstack.stackTagCompound.setInteger("secondElement", secondElement);
		itemstack.stackTagCompound.setInteger("thirdElement", thirdElement);
	}

	@Override
	public void addInformation(ItemStack itemstack,
			EntityPlayer player, List par3List, boolean par4)
	{
//		if (itemstack.stackTagCompound != null) 
//		{
//			String owner = itemstack.stackTagCompound.getString("owner");
//			int currentElement = itemstack.stackTagCompound.getInteger("firstElement");
//			par3List.add("owner: " + owner);
//			if (owner.equals(player.getCommandSenderName())) 
//			{
//				par3List.add(EnumChatFormatting.GREEN + "code: " + currentElement);
//			} 
//			else 
//			{
//				par3List.add(EnumChatFormatting.RED + "code: " + EnumChatFormatting.OBFUSCATED + currentElement);
//			}
//		}
	}
	
	public void onSelectedElement(ItemStack itemstack, EntityPlayer player, int current)
	{
		
		
		if (current >= selectedElement)
		{
			onFirstSelection(itemstack, player);
		}
		
		if (current < 0)
		{
			onLastSelection(itemstack, player);
		}
		
		if (current > 4 || current < 0)
		{
			onNextSelection(itemstack, player);
		}
		
		onForceSelection(itemstack, player);
	}
	
	public void onFirstSelection(ItemStack itemstack, EntityPlayer player)
	{
		if (selectedElement > 0)
		{
			onSelectedElement(itemstack, player, 0);
		}
	}
	
	public void onNextSelection(ItemStack itemstack, EntityPlayer player)
	{
		if (selectedElement == firstElement)
		{
			selectedElement += 1;
		}
	}
	
	public void onLastSelection(ItemStack itemstack, EntityPlayer player)
	{
		if (selectedElement > 4)
		{
			onSelectedElement(itemstack, player, selectedElement - 1);
		}
	}
	
	public void onForceSelection(ItemStack itemstack, EntityPlayer player)
	{
		firstElement = selectedElement;
	}
}
