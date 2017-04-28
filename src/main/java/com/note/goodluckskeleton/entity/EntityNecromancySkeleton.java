package com.note.goodluckskeleton.entity;

import java.util.UUID;

import com.google.common.base.Optional;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.world.World;

public class EntityNecromancySkeleton extends EntityCreature {
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityNecromancySkeleton.class, DataSerializers.FLOAT);
    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntityNecromancySkeleton.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    
	public EntityNecromancySkeleton(World worldIn) {
		super(worldIn);
	    this.setSize(0.6F, 1.99F);
	}
	
	
}