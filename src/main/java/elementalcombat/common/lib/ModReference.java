package elementalcombat.common.lib;

import elementalcombat.common.core.CommonProxy;
import elementalcombat.common.network.PacketPipeline;

public class ModReference 
{
    public static final String MODID = "elementalcombat";
    public static final String NAME = "Elemental Combat";
    public static final String VERSION = "1.0";
    public static final String CHANNEL = "ElementalCombat";
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	public static final CommonProxy proxy = new CommonProxy();
}
