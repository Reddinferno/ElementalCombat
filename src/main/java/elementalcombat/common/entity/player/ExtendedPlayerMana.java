package elementalcombat.common.entity.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import elementalcombat.common.core.CommonProxy;
import elementalcombat.common.lib.ModReference;
import elementalcombat.common.network.packet.SyncPlayerPropsPacket;

public class ExtendedPlayerMana implements IExtendedEntityProperties
{
	public static final String MANA_NAME = "ManaPlayer";
	private final EntityPlayer player;
	private int manaMax, manaRegen;
	private static int WATCH_MANA = 20;
	
	public ExtendedPlayerMana(EntityPlayer player)
	{
		this.player = player;
		this.manaMax = 100;
		this.player.getDataWatcher().addObject(WATCH_MANA, this.manaMax);
	}
	
	public static void register(EntityPlayer player)
	{
		player.registerExtendedProperties(MANA_NAME, new ExtendedPlayerMana(player));
	}
	
	public static final ExtendedPlayerMana get(EntityPlayer player)
	{
		return (ExtendedPlayerMana)player.getExtendedProperties(MANA_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("CurrentMana", player.getDataWatcher().getWatchableObjectInt(WATCH_MANA));
		properties.setInteger("MaxMana", manaMax);
		compound.setTag(MANA_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound)compound.getTag(MANA_NAME);
		player.getDataWatcher().updateObject(WATCH_MANA, properties.getInteger("CurrentMana"));
		manaMax = properties.getInteger("MaxMana");
		System.out.println("Mana from NBT" + player.getDataWatcher().getWatchableObjectByte(WATCH_MANA) + "/" + manaMax);
	}

	@Override
	public void init(Entity entity, World world)
	{
	}
	
	public final void setCurrentMana(int amount)
	{
		player.getDataWatcher().updateObject(WATCH_MANA, amount > 0 ? (amount < manaMax ? amount : manaMax) : 0);
	}
	
	public final int getMaxMana()
	{
		return this.manaMax;
	}
	
	public final int getCurrentMana()
	{
		return player.getDataWatcher().getWatchableObjectInt(WATCH_MANA);
	}
	
	public final boolean consumeMana(int amount)
	{
		boolean sufficient = amount <= getCurrentMana();
		setCurrentMana(getCurrentMana() - amount);
		return sufficient;
	}
	
	public final void refillMana()
	{
		player.getDataWatcher().updateObject(WATCH_MANA, manaMax);
	}
	
	public final void setMaxMana(int amount) 
	{
		manaMax = (amount > 0 ? amount : 0);
		ModReference.packetPipeline.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
	}
	
	private static final String getSaveKey(EntityPlayer player) 
	{
		return player.getCommandSenderName() + ":" + MANA_NAME;
	}

	public static final void saveProxyData(EntityPlayer player) 
	{
		NBTTagCompound savedData = new NBTTagCompound();
		ExtendedPlayerMana.get(player).saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static final void loadProxyData(EntityPlayer player) 
	{
		ExtendedPlayerMana playerData = ExtendedPlayerMana.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		if (savedData != null) { playerData.loadNBTData(savedData); }
	}


}
