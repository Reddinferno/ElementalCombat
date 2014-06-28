package elementalcombat.common.models.weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TridentModel extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape25;
    ModelRenderer Shape26;
    ModelRenderer Shape27;
  
  public TridentModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 40, 0);
      Shape1.addBox(-3F, 0F, -3F, 6, 1, 6);
      Shape1.setRotationPoint(0F, 23F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 56, 8);
      Shape2.addBox(-1F, 0F, 0F, 2, 6, 2);
      Shape2.setRotationPoint(0F, 17F, 2F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, -0.3490659F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 47, 8);
      Shape3.addBox(-1F, 0F, -2F, 2, 6, 2);
      Shape3.setRotationPoint(0F, 17F, -2F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0.3490659F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 48, 17);
      Shape4.addBox(-1F, 0F, -2F, 4, 6, 4);
      Shape4.setRotationPoint(-1F, 17F, 0F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 56, 28);
      Shape5.addBox(-1F, 0F, -2F, 2, 6, 2);
      Shape5.setRotationPoint(0F, 13F, 0F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, -0.5235988F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 47, 28);
      Shape6.addBox(-1F, 0F, 0F, 2, 6, 2);
      Shape6.setRotationPoint(0F, 13F, 0F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0.5235988F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 29);
      Shape7.addBox(-1F, 0F, -1F, 2, 33, 2);
      Shape7.setRotationPoint(0F, -16F, 0F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 9, 29);
      Shape8.addBox(-1F, 0F, -1F, 2, 33, 2);
      Shape8.setRotationPoint(0F, -16F, 0F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, -0.7853982F, 0F);
      Shape9 = new ModelRenderer(this, 18, 29);
      Shape9.addBox(-1F, 0F, -1F, 2, 33, 2);
      Shape9.setRotationPoint(0F, -16F, 0F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, -0.3490659F, 0F);
      Shape10 = new ModelRenderer(this, 27, 29);
      Shape10.addBox(-1F, 0F, -1F, 2, 33, 2);
      Shape10.setRotationPoint(0F, -16F, 0F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0.3490659F, 0F);
      Shape11 = new ModelRenderer(this, 38, 8);
      Shape11.addBox(-2F, 0F, -1F, 2, 6, 2);
      Shape11.setRotationPoint(-2F, 17F, 0F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, -0.3490659F);
      Shape12 = new ModelRenderer(this, 56, 37);
      Shape12.addBox(-2F, 0F, -1F, 2, 6, 2);
      Shape12.setRotationPoint(0F, 13F, 0F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0.5235988F);
      Shape13 = new ModelRenderer(this, 29, 8);
      Shape13.addBox(0F, 0F, -1F, 2, 6, 2);
      Shape13.setRotationPoint(2F, 17F, 0F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0.3490659F);
      Shape14 = new ModelRenderer(this, 47, 37);
      Shape14.addBox(0F, 0F, -1F, 2, 6, 2);
      Shape14.setRotationPoint(0F, 13F, 0F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, -0.5235988F);
      Shape15 = new ModelRenderer(this, 52, 46);
      Shape15.addBox(-1F, 0F, -1F, 3, 7, 3);
      Shape15.setRotationPoint(-0.5F, -10F, -0.5F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 36, 56);
      Shape16.addBox(-1F, 0F, -6F, 2, 2, 6);
      Shape16.setRotationPoint(0F, -21F, 2F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 1.047198F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 30, 20);
      Shape17.addBox(-1F, 0F, 0F, 2, 2, 6);
      Shape17.setRotationPoint(0F, -21F, -2F);
      Shape17.setTextureSize(64, 32);
      Shape17.mirror = true;
      setRotation(Shape17, -1.047198F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 15, 21);
      Shape18.addBox(-1F, 0F, -5F, 2, 2, 5);
      Shape18.setRotationPoint(0F, -22F, 7F);
      Shape18.setTextureSize(64, 32);
      Shape18.mirror = true;
      setRotation(Shape18, 0.1745329F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 25, 0);
      Shape19.addBox(-1F, 0F, 0F, 2, 2, 5);
      Shape19.setRotationPoint(0F, -22F, -7F);
      Shape19.setTextureSize(64, 32);
      Shape19.mirror = true;
      setRotation(Shape19, -0.1745329F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 36, 35);
      Shape20.addBox(-1F, 0F, -1F, 2, 18, 2);
      Shape20.setRotationPoint(0F, -34F, 0F);
      Shape20.setTextureSize(64, 32);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 0, 24);
      Shape21.addBox(-1F, 0F, 0F, 2, 2, 2);
      Shape21.setRotationPoint(0F, -35F, 0F);
      Shape21.setTextureSize(64, 32);
      Shape21.mirror = true;
      setRotation(Shape21, -0.7853982F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 16, 0);
      Shape22.addBox(-1F, 0F, -2F, 2, 7, 2);
      Shape22.setRotationPoint(0F, -27F, -6F);
      Shape22.setTextureSize(64, 32);
      Shape22.mirror = true;
      setRotation(Shape22, -0.0872665F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 7, 0);
      Shape23.addBox(-1F, 0F, 0F, 2, 7, 2);
      Shape23.setRotationPoint(0F, -27F, 6F);
      Shape23.setTextureSize(64, 32);
      Shape23.mirror = true;
      setRotation(Shape23, 0.0872665F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 0, 18);
      Shape24.addBox(-1F, 0F, 0F, 2, 3, 2);
      Shape24.setRotationPoint(0F, -29F, 6F);
      Shape24.setTextureSize(64, 32);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
      Shape25 = new ModelRenderer(this, 0, 11);
      Shape25.addBox(-1F, 0F, 0F, 2, 4, 2);
      Shape25.setRotationPoint(0F, -30F, 5F);
      Shape25.setTextureSize(64, 32);
      Shape25.mirror = true;
      setRotation(Shape25, 0.7330383F, 0F, 0F);
      Shape26 = new ModelRenderer(this, 20, 15);
      Shape26.addBox(-1F, 0F, -2F, 2, 3, 2);
      Shape26.setRotationPoint(0F, -29F, -6F);
      Shape26.setTextureSize(64, 32);
      Shape26.mirror = true;
      setRotation(Shape26, 0F, 0F, 0F);
      Shape27 = new ModelRenderer(this, 9, 14);
      Shape27.addBox(-1F, 0F, -2F, 2, 4, 2);
      Shape27.setRotationPoint(0F, -30F, -5F);
      Shape27.setTextureSize(64, 32);
      Shape27.mirror = true;
      setRotation(Shape27, -0.7330383F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
    Shape24.render(f5);
    Shape25.render(f5);
    Shape26.render(f5);
    Shape27.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, par7);
  }

}