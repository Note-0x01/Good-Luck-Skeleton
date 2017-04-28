package com.note.goodluckskeleton.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SkeletalItems {
	public static ItemNecromancyStaff necromancy_staff;
	
	public static void init() {
		necromancy_staff = new ItemNecromancyStaff();
	}
	
	public static void modelInit() {
		ModelLoader.setCustomModelResourceLocation(necromancy_staff, 0, new ModelResourceLocation(necromancy_staff.getRegistryName(), "inventory"));
	}
}
