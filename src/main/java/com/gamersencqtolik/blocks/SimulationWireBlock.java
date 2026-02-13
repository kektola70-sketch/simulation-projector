 package com.gamersencqtolik.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateDefinition;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SimulationWireBlock extends Block {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public SimulationWireBlock() {
        super(AbstractBlock.Properties.of(Material.DECORATION).strength(0.5f).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!world.isClientSide) {
            boolean hasSignal = world.hasNeighborSignal(pos);
            if (state.getValue(POWERED) != hasSignal) {
                world.setBlock(pos, state.setValue(POWERED, hasSignal), 3);
            }
        }
    }
}