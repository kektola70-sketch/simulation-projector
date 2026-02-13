 package com.gamersencqtolik.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.HashSet;
import java.util.Set;

public class ProjectorBlock extends Block {
    public ProjectorBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(3.0f));
    }

    public boolean canWork(World world, BlockPos pos) {
        return checkConnection(world, pos, new HashSet<>());
    }

    private boolean checkConnection(World world, BlockPos pos, Set<BlockPos> visited) {
        for (Direction dir : Direction.values()) {
            BlockPos neighbor = pos.relative(dir);
            if (visited.contains(neighbor)) continue;
            visited.add(neighbor);

            Block block = world.getBlockState(neighbor).getBlock();
            if (block == ModBlocks.CODE_MACHINE.get()) return true;
            if (block instanceof SimulationWireBlock) {
                if (checkConnection(world, neighbor, visited)) return true;
            }
        }
        return false;
    }
}