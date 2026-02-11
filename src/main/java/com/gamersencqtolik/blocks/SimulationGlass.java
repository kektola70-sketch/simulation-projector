public static final RegistryObject<Block> SIM_GLASS = BLOCKS.register("sim_glass",
    () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
        .hardnessAndResistance(-1.0F, 3600000.0F) // Не ломается
        .sound(SoundType.GLASS)
        .notSolid()));