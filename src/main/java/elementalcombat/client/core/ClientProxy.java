package elementalcombat.client.core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import elementalcombat.client.gui.GuiManaData;
import elementalcombat.client.render.RenderHammerModel;
import elementalcombat.client.render.RenderSpearModel;
import elementalcombat.client.render.RenderTridentModel;
import elementalcombat.common.core.CommonProxy;
import elementalcombat.common.lib.ModWeapons;

public class ClientProxy extends CommonProxy
{
	@Override
	public void load()
	{
		renderModels();
		MinecraftForge.EVENT_BUS.register(new GuiManaData(Minecraft.getMinecraft()));
	}
	
	private void renderModels()
	{
		MinecraftForgeClient.registerItemRenderer(ModWeapons.weaponWater, new RenderTridentModel());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.weaponEarth, new RenderHammerModel());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.weaponLightning, new RenderSpearModel());
	}
}
