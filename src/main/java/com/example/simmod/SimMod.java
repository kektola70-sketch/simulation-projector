package com.yourname.simmod;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("simmod")
public class SimMod {

    public SimMod() {
        // Получаем шину событий для регистрации блоков и предметов
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Регистрируем наши блоки и предметы
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Регистрируем метод настройки клиента
        modEventBus.addListener(this::doClientStuff);

        // Регистрируем сам мод в шине событий Forge
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Этот метод отвечает за графику. Он нужен, чтобы стекло было прозрачным.
    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Указываем игре, что блок SIM_GLASS может иметь прозрачные пиксели (Cutout)
            RenderTypeLookup.setRenderLayer(ModBlocks.SIM_GLASS.get(), RenderType.getCutout());
            
            // Если ты хочешь, чтобы провода тоже были прозрачными (если на текстуре есть пустые места):
            RenderTypeLookup.setRenderLayer(ModBlocks.SIM_WIRE.get(), RenderType.getCutout());
        });
    }
}