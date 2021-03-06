package com.note.goodluckskeleton.entity;

import com.note.goodluckskeleton.GoodLuckSkeleton;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNecromancySkeleton extends RenderLiving<EntityNecromancySkeleton>
{
    private static final ResourceLocation SKELETON_TEXTURES = new ResourceLocation(GoodLuckSkeleton.MODID + ":textures/entity/necromancyskeleton/necromancyskeleton.png");

    public RenderNecromancySkeleton(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelNecromancySkeleton(), 0.5F);
        this.addLayer(new LayerHeldItem(this));
    }

    public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityNecromancySkeleton entity)
    {
        return SKELETON_TEXTURES;
    }
}
