package elementalcombat.common.lib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import elementalcombat.common.items.weapon.ItemAirElement;
import elementalcombat.common.items.weapon.ItemEarthElement;
import elementalcombat.common.items.weapon.ItemFireElement;
import elementalcombat.common.items.weapon.ItemIceElement;
import elementalcombat.common.items.weapon.ItemLightningElement;
import elementalcombat.common.items.weapon.ItemMagmaElement;
import elementalcombat.common.items.weapon.ItemNatureElement;
import elementalcombat.common.items.weapon.ItemWaterElement;

public class ModWeapons
{
	public static Item 
	weaponFire,
	weaponWater,
	weaponEarth,
	weaponAir,
	weaponMagma,
	weaponIce,
	weaponNature,
	weaponLightning;
	
	public static ToolMaterial	
	fireMaterial = EnumHelper.addToolMaterial("fireMaterial", 0, 265, 2, 7, 0),
	waterMaterial = EnumHelper.addToolMaterial("waterMaterial", 0, 562, 2, 9, 0),
	earthMaterial = EnumHelper.addToolMaterial("earthMaterial", 0, 565, 2, 9, 0),
	airMaterial = EnumHelper.addToolMaterial("airMaterial", 0, 326, 2, 12, 0),
	magmaMaterial = EnumHelper.addToolMaterial("magmaMaterial", 0, 252, 0, 0, 0),
	iceMaterial = EnumHelper.addToolMaterial("iceMaterial", 0, 552, 0, 0, 0),
	natureMaterial = EnumHelper.addToolMaterial("natureMaterial", 0, 522, 0, 6, 0),
	lightningMaterial = EnumHelper.addToolMaterial("lightningMaterial", 0, 653, 0, 9, 0);

	public static void weapon()
	{
		weaponFire = new ItemFireElement(fireMaterial).setUnlocalizedName("itemFire");
		weaponWater = new ItemWaterElement(waterMaterial).setUnlocalizedName("itemWater");
		weaponEarth = new ItemEarthElement(earthMaterial).setUnlocalizedName("itemEarth");
		weaponAir = new ItemAirElement(airMaterial).setUnlocalizedName("itemAir");
		weaponMagma = new ItemMagmaElement(magmaMaterial).setUnlocalizedName("itemMagma");
		weaponIce = new ItemIceElement(iceMaterial).setUnlocalizedName("itemIce");
		weaponNature = new ItemNatureElement(natureMaterial).setUnlocalizedName("itemNature");
		weaponLightning = new ItemLightningElement(lightningMaterial).setUnlocalizedName("itemLightning");
		GameRegistry.registerItem(weaponFire, weaponFire.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponWater, weaponWater.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponEarth, weaponEarth.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponAir, weaponAir.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponMagma, weaponMagma.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponIce, weaponIce.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponNature, weaponNature.getUnlocalizedName(), ModReference.MODID);
		GameRegistry.registerItem(weaponLightning, weaponLightning.getUnlocalizedName(), ModReference.MODID);
	}
}
