 package com.gamersencqtolik.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "simmod");

    public static final RegistryObject<Block> SIM_GLASS = BLOCKS.register("sim_glass",
        () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
            .strength(-1.0F, 3600000.0F).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> SIM_WIRE = BLOCKS.register("sim_wire", 
        () -> new SimulationWireBlock());

    public static final RegistryObject<Block> CODE_MACHINE = BLOCKS.register("code_machine",
        () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(3.0f)));

    public static final RegistryObject<Block> SIM_PROJECTOR = BLOCKS.register("sim_projector",
        () -> new ProjectorBlock());
}