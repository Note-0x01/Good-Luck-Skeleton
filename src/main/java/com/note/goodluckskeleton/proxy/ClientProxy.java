package com.note.goodluckskeleton.proxy;

import com.note.goodluckskeleton.GoodLuckSkeleton;
import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;
import com.note.goodluckskeleton.entity.ModelNecromancySkeleton;
import com.note.goodluckskeleton.entity.RenderNecromancySkeleton;
import com.note.goodluckskeleton.items.SkeletalItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		SkeletalItems.init();
		SkeletalItems.modelInit();
        ResourceLocation resourceLocation = new ResourceLocation(GoodLuckSkeleton.MODID, "necromancy_skeleton");
		EntityRegistry.registerModEntity(resourceLocation, EntityNecromancySkeleton.class, "necromancy_skeleton", 0, GoodLuckSkeleton.instance, 128, 214, true, 0, 0);
		RenderingRegistry.registerEntityRenderingHandler(EntityNecromancySkeleton.class, RenderNecromancySkeleton::new);
	}
	
	@Override
	public void init() {
		System.out.print("REE");
		
	}
}
