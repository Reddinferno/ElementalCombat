package elementalcombat.common.core;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerElement
{
	@SubscribeEvent
	public void onAura(RenderPlayerEvent event)
	{
		RenderPlayer render = event.renderer;
		EntityPlayer player = event.entityPlayer;
        String s = EnumChatFormatting.getTextWithoutFormattingCodes(event.entityLiving.getCommandSenderName());
		if ((s.equals("Reddinferno") || s.equals("Cybrius")) && (!(event.entityLiving instanceof EntityPlayer)));
		{
			System.out.println("This person is part of a List");
			
		}
	}
}
