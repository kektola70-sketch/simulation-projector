public class CodeMachine extends Block {
    public CodeMachine() {
        super(AbstractBlock.Properties.create(Material.IRON));
    }

    // Пример: при клике ставит блок под собой в состояние "запитан"
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        // Логика проверки кода и включения сигнала
        return ActionResultType.SUCCESS;
    }
}