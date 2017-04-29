package com.note.goodluckskeleton.items;

import com.note.goodluckskeleton.ConfigHandler;
import com.note.goodluckskeleton.GoodLuckSkeleton;
import com.note.goodluckskeleton.ISkeleCount;
import com.note.goodluckskeleton.SkeleCountProvider;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemNecromancyStaff extends Item {
	private static final String name = "necromancy_staff";
	
	public ItemNecromancyStaff() {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		setMaxDamage(ConfigHandler.itemUses-1);
		GameRegistry.register(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote) {
			ISkeleCount skele_count = player.getCapability(SkeleCountProvider.skele_count, null);
			if(skele_count.getCount() != ConfigHandler.skeletonMax) {
				player.getHeldItem(hand).damageItem(1, player);
				EntityNecromancySkeleton skele = new EntityNecromancySkeleton(worldIn);
				skele.setOwnerId(player.getUniqueID());
				skele.setCustomNameTag(player.getName() +"'s Skeleton" + " §7<FOLLOWING>");
				skele.setName(player.getName() +"'s Skeleton");
				skele.setAlwaysRenderNameTag(true);
				skele.setTamed(true);
				skele_count.add();
				skele.setLocationAndAngles(pos.getX(), pos.getY()+1,pos.getZ(), MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
				worldIn.spawnEntity(skele);
				String message = String.format("You now have §7%d§r skeletons.", (int) skele_count.getCount());

				player.sendMessage(new TextComponentString(message));
			} else {
				String message = String.format("You already have "+ ConfigHandler.skeletonMax + " skeletons!");

				player.sendMessage(new TextComponentString(message));
			}
		}
	    return EnumActionResult.PASS;
	}
}
