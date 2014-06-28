package elementalcombat.common.lib;

import net.minecraft.entity.Entity;
import cpw.mods.fml.common.registry.EntityRegistry;
import elementalcombat.common.ElementalCombat;
import elementalcombat.common.entity.element.nature.EntityImplosionDetection;

public class ModEntityElement
{
	private static void loadEntity()
	{
		entity(EntityImplosionDetection.class, "entityImplostion");
	}

	protected static void entity(Class<? extends Entity> entity, String name)
	{
		int modEntityID = 0;
		EntityRegistry.registerModEntity(entity, name, modEntityID++, ElementalCombat.instance, 64, 20, true);
		EntityRegistry.registerGlobalEntityID(entity, name, modEntityID++);
	}
	
	public static void entity()
	{
		loadEntity();
	}
}
