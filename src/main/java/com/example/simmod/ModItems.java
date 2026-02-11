package com.example.simmod;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "simmod");

    public static final RegistryObject<Item> SIM_GLASS_ITEM = ITEMS.register("sim_glass",
        () -> new BlockItem(ModBlocks.SIM_GLASS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Item> SIM_WIRE_ITEM = ITEMS.register("sim_wire",
        () -> new BlockItem(ModBlocks.SIM_WIRE.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Item> CODE_MACHINE_ITEM = ITEMS.register("code_machine",
        () -> new BlockItem(ModBlocks.CODE_MACHINE.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    public static final RegistryObject<Item> SIM_PROJECTOR_ITEM = ITEMS.register("sim_projector",
        () -> new BlockItem(ModBlocks.SIM_PROJECTOR.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
}