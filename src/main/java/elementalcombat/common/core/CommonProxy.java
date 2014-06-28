package elementalcombat.common.core;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	private static final Map<String, NBTTagCompound> entityData = new HashMap<String, NBTTagCompound>();

	public void load()
	{
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z)
	{
		return null;
	}
	
	public static void storeEntityData(String name, NBTTagCompound compound) 
	{
		entityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) 
	{
		return entityData.remove(name);
	}


}
