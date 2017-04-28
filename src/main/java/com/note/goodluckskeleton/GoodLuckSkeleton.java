package com.note.goodluckskeleton;

import com.note.goodluckskeleton.entity.EntityNecromancySkeleton;
import com.note.goodluckskeleton.items.SkeletalItems;
import com.note.goodluckskeleton.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
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
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "com.note.goodluckskeleton.proxy.ClientProxy", serverSide = "com.note.goodluckskeleton.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance("goodluckskeleton")
    public static GoodLuckSkeleton instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
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
    
    
}
