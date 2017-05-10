package com.note.goodluckskeleton;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;
import com.note.goodluckskeleton.items.SkeletalItems;
import com.note.goodluckskeleton.items.SkeletalRecipes;
import com.note.goodluckskeleton.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = GoodLuckSkeleton.MODID, version = GoodLuckSkeleton.VERSION)
public class GoodLuckSkeleton
{
    public static final String MODID = "goodluckskeleton";
    public static final String VERSION = "1.0";
    
    public static Logger logger;
    
    @SidedProxy(clientSide = "com.note.goodluckskeleton.proxy.ClientProxy", serverSide = "com.note.goodluckskeleton.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance("goodluckskeleton")
    public static GoodLuckSkeleton instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	logger = event.getModLog();
    	
    	configDir = new File(event.getModConfigurationDirectory() + "/" + MODID);
    	configDir.mkdirs();
    	ConfigHandler.init(new File(configDir.getPath(), MODID + ".cfg"));
    	
		SkeletalItems.init();
		
        ResourceLocation resourceLocation = new ResourceLocation(GoodLuckSkeleton.MODID, "necromancy_skeleton");
		EntityRegistry.registerModEntity(resourceLocation, EntityNecromancySkeleton.class, "necromancy_skeleton", 0, GoodLuckSkeleton.instance, 128, 1, true);
		
		CapabilityManager.INSTANCE.register(ISkeleCount.class, new GoodLuckPlayer(), SkeleCount.class);
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new SkeletalEventHandler());
		
		SkeletalRecipes.initRecipes();
		
    	proxy.preInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
    
    
    private static File configDir;
    public static File getConfigDir() {
    	return configDir;
    }
    
    
}
