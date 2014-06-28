package elementalcombat.common.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import elementalcombat.common.entity.player.ExtendedPlayerMana;
import elementalcombat.common.network.AbstractPacket;

public class SyncPlayerPropsPacket extends AbstractPacket
{
	private NBTTagCompound data;
	
	public SyncPlayerPropsPacket()
	{
		
	}
	
	public SyncPlayerPropsPacket(EntityPlayer player)
	{
		data = new NBTTagCompound();
		ExtendedPlayerMana.get(player).saveNBTData(data);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		ByteBufUtils.writeTag(buffer, data);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		data = ByteBufUtils.readTag(buffer);
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{
		ExtendedPlayerMana.get(player).loadNBTData(data);
	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
	}

}
