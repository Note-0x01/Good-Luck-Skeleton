package com.note.goodluckskeleton;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	
	public static int skeletonMax;
	public static int itemUses;
	
	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}
	
	public static void syncConfig() {
		String category;
		
		category = "Good Luck, Skeleton!";
		skeletonMax = config.getInt("skeletonMax", category, 5, 1, 128, "The max amount of skeletons a user can spawn.");
		itemUses = config.getInt("staffUses", category, 5, 1, -1, "The amount of times the Necromancy Staff can be used.");
		
		config.save();
	}
}
