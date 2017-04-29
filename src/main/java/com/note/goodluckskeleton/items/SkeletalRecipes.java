package com.note.goodluckskeleton.items;

import com.note.goodluckskeleton.ConfigHandler;
import com.note.goodluckskeleton.GoodLuckSkeleton;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SkeletalRecipes {
	public static void initRecipes() {
		ItemStack skull = new ItemStack(Items.SKULL, 1, 0);
		GameRegistry.addShapedRecipe(new ItemStack(SkeletalItems.necromancy_staff), "U", "#", "#", '#', Items.BONE, 'U', SkeletalItems.necromancy_core);
		GameRegistry.addShapedRecipe(new ItemStack(SkeletalItems.necromancy_core), "###", "#H#", "###", '#', Items.BONE, 'H', skull);
	}
}
