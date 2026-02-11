package com.example.simmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("simmod")
public class SimMod {
    public SimMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}