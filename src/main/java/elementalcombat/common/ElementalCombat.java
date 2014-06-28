package elementalcombat.common;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import elementalcombat.common.core.CommonProxy;
import elementalcombat.common.core.EventHandlerElement;
import elementalcombat.common.lib.ModReference;
import elementalcombat.common.lib.ModWeapons;

@Mod(modid = ModReference.MODID, name = ModReference.NAME, version = ModReference.VERSION)
public class ElementalCombat
{
	@Instance("ElementalCombat")
	public static ElementalCombat instance;
	
    @SidedProxy(clientSide = "elementalcombat.client.core.ClientProxy", serverSide = "elementalcombat.common.core.CommonProxy")

    public static CommonProxy proxy;

    private static final Logger logger = LogManager.getLogger("ElementalCombat");
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		ModWeapons.weapon();
	}
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModReference.packetPipeline.initialise();
    	proxy.load();
		MinecraftForge.EVENT_BUS.register(new EventHandlerElement());
   	}
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	ModReference.packetPipeline.postInitialise();
    }
}
