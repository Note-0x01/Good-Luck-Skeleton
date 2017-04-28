package com.note.goodluckskeleton.items;

import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemNecromancyStaff extends Item {
	private static final String name = "necromancy_staff";
	
	public ItemNecromancyStaff() {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		GameRegistry.register(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote) {
			EntityNecromancySkeleton skele = new EntityNecromancySkeleton(worldIn);
			skele.setLocationAndAngles(pos.getX(), pos.getY()+1,pos.getZ(), MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
			worldIn.spawnEntity(skele);
		}
	    return EnumActionResult.PASS;
	}
}
