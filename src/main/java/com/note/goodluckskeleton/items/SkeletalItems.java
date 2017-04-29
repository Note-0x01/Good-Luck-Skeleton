package com.note.goodluckskeleton.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SkeletalItems {
	public static ItemNecromancyStaff necromancy_staff;
	public static ItemNecromancyCore necromancy_core;
	
	public static void init() {
		necromancy_staff = new ItemNecromancyStaff();
		necromancy_core = new ItemNecromancyCore();
	}
	
	public static void modelInit() {
		ModelLoader.setCustomModelResourceLocation(necromancy_staff, 0, new ModelResourceLocation(necromancy_staff.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(necromancy_core, 0, new ModelResourceLocation(necromancy_core.getRegistryName(), "inventory"));
	}
}
