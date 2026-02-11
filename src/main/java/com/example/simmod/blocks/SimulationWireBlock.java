package com.example.simmod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SimulationWireBlock extends Block {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public SimulationWireBlock() {
        super(AbstractBlock.Properties.create(Material.MISC).hardnessAndResistance(0.5f).notSolid());
        this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    // Логика передачи сигнала при изменении блоков рядом
    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!world.isRemote) {
            boolean hasSignal = world.isBlockPowered(pos);
            if (state.get(POWERED) != hasSignal) {
                world.setBlockState(pos, state.with(POWERED, hasSignal), 3);
            }
        }
    }
}