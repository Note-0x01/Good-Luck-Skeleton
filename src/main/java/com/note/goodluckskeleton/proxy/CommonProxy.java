package com.note.goodluckskeleton.proxy;

import com.note.goodluckskeleton.CapabilityHandler;
import com.note.goodluckskeleton.EventHandler;
import com.note.goodluckskeleton.GoodLuckPlayer;
import com.note.goodluckskeleton.GoodLuckSkeleton;
import com.note.goodluckskeleton.ISkeleCount;
import com.note.goodluckskeleton.SkeleCount;
import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;
import com.note.goodluckskeleton.items.SkeletalItems;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {

	public void preInit() {
		SkeletalItems.init();
        ResourceLocation resourceLocation = new ResourceLocation(GoodLuckSkeleton.MODID, "necromancy_skeleton");
		EntityRegistry.registerModEntity(resourceLocation, EntityNecromancySkeleton.class, "necromancy_skeleton", 0, GoodLuckSkeleton.instance, 128, 1, true, 0, 0);
		CapabilityManager.INSTANCE.register(ISkeleCount.class, new GoodLuckPlayer(), SkeleCount.class);
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	public void init() {
		
	}

}
