package com.note.goodluckskeleton.items;

import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemNecromancyCore extends Item {
	private static final String name = "necromancy_core";
	
	public ItemNecromancyCore() {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		GameRegistry.register(this);
	}
}
