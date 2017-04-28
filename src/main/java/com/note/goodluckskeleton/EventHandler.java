package com.note.goodluckskeleton;

import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventHandler {
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		EntityPlayer player = event.getEntityPlayer();
		ISkeleCount skele_count = player.getCapability(SkeleCountProvider.skele_count, null);
		ISkeleCount oldskele_count = event.getOriginal().getCapability(SkeleCountProvider.skele_count, null);
		
		skele_count.set(oldskele_count.getCount());
	}
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		Entity entity = event.getEntityLiving();
		if (entity instanceof EntityNecromancySkeleton) {
			EntityNecromancySkeleton skele = (EntityNecromancySkeleton)entity;
			EntityLivingBase player = skele.getOwner();
			ISkeleCount skele_count = player.getCapability(SkeleCountProvider.skele_count, null);
			
			skele_count.sub();
		}
	}
}
