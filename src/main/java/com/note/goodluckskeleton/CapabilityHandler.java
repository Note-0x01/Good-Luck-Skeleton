package com.note.goodluckskeleton;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if(canHaveAttributes(event.getObject())) {
			EntityLivingBase ent = (EntityLivingBase) event.getObject();

			if (ent instanceof EntityPlayer)
				event.addCapability(SkeleCountProvider.key, new SkeleCountProvider());
		}

	 }
	
	public static boolean canHaveAttributes(Entity entity) {
		if (entity instanceof EntityLivingBase)
			return true;
		return false;
	}
}
