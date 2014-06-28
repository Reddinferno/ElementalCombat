package elementalcombat.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import elementalcombat.common.lib.ModTextureLocation;
import elementalcombat.common.models.weapons.TridentModel;

public class RenderTridentModel implements IItemRenderer 
{
	protected TridentModel trident;

	public RenderTridentModel()
	{
		trident = new TridentModel();
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
			Minecraft.getMinecraft().renderEngine.bindTexture(ModTextureLocation.modelTrident);
			float scale = 0.8F;
			GL11.glScalef(scale, 0.6F, scale);
			GL11.glRotatef(-200F, -390.0F, -90.0F, -430.0F);
			GL11.glRotatef(-370F, -260.0F, 0, 0);
			GL11.glTranslatef(-0.07F, 0.55F, 1.00F);
			trident.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		break;
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(ModTextureLocation.modelTrident);
			float scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			GL11.glRotatef(-200F, -390.0F, -90.0F, -430.0F);
			GL11.glRotatef(-370F, -260.0F, 0, 0);
			GL11.glTranslatef(-0.07F, 0.55F, 1.00F);
			trident.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}	
			break;
			
		default:
			break;
		}
	}

}