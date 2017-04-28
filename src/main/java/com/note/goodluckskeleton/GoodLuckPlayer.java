package com.note.goodluckskeleton;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public final class GoodLuckPlayer implements IStorage<ISkeleCount> {

	@Override
	public NBTBase writeNBT(Capability<ISkeleCount> capability, ISkeleCount instance, EnumFacing side) {
		return new NBTTagInt(instance.getCount());
	}

	@Override
	public void readNBT(Capability<ISkeleCount> capability, ISkeleCount instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTPrimitive)nbt).getInt());
	}

}
