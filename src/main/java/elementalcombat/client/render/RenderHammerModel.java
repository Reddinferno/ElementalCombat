package elementalcombat.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import elementalcombat.common.lib.ModTextureLocation;
import elementalcombat.common.models.weapons.HammerModel;

/**
 *@mod Elemental Warfare
 *
 *@author Reddinferno
 */

public class RenderHammerModel implements IItemRenderer 
{
	protected HammerModel hammer;

	public RenderHammerModel()
	{
		hammer = new HammerModel();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch(type)

		{
		case EQUIPPED_FIRST_PERSON: return true;
		case EQUIPPED: return true;
		case ENTITY: return true;
		case INVENTORY: return true;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(ModTextureLocation.modelHammer);
			float scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(-200F, -390.0F, -90.0F, -430.0F);
			GL11.glRotatef(-370F, -260.0F, 0, 0);
			GL11.glTranslatef(-0.05F, -1.0F, 0.47F);
			hammer.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		break;
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(ModTextureLocation.modelHammer);
			float scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(-200F, -390.0F, -90.0F, -430.0F);
			GL11.glRotatef(-370F, -260.0F, 0, 0);
			GL11.glTranslatef(-0.05F, -1.0F, 0.47F);
			hammer.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}	
			break;
			
		default:
			break;
		}
	}

}
