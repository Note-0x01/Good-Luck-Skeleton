package com.note.goodluckskeleton;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SkeleCountProvider implements ICapabilitySerializable<NBTBase> {
	
	 @CapabilityInject(ISkeleCount.class)
	 public static Capability<ISkeleCount> skele_count = null;
	 public static ResourceLocation key = new ResourceLocation(GoodLuckSkeleton.MODID, "skele_count");
	 
	 private ISkeleCount instance = skele_count.getDefaultInstance();

	@Override
	 public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		 return capability == skele_count;
	 }

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == skele_count ? skele_count.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return skele_count.getStorage().writeNBT(skele_count, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		skele_count.getStorage().readNBT(skele_count, this.instance, null, nbt);
	}
}
