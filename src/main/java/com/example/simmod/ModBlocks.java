package com.example.simmod;

import com.example.simmod.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "simmod");

    // Стекло (неразрушимое)
    public static final RegistryObject<Block> SIM_GLASS = BLOCKS.register("sim_glass",
        () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
            .hardnessAndResistance(-1.0F, 3600000.0F).sound(SoundType.GLASS).notSolid()));

    // Провод
    public static final RegistryObject<Block> SIM_WIRE = BLOCKS.register("sim_wire", 
        () -> new SimulationWireBlock());

    // Кодовая машина
    public static final RegistryObject<Block> CODE_MACHINE = BLOCKS.register("code_machine",
        () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3.0f)));

    // Проектор
    public static final RegistryObject<Block> SIM_PROJECTOR = BLOCKS.register("sim_projector",
        () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3.0f)));
}