public boolean canWork(World world, BlockPos pos) {
    Set<BlockPos> visited = new HashSet<>();
    return checkConnection(world, pos, visited);
}

private boolean checkConnection(World world, BlockPos pos, Set<BlockPos> visited) {
    for (Direction dir : Direction.values()) {
        BlockPos neighbor = pos.offset(dir);
        if (visited.contains(neighbor)) continue;
        visited.add(neighbor);

        Block block = world.getBlockState(neighbor).getBlock();
        if (block instanceof CodeMachine) return true; // Нашли машину!
        if (block instanceof SimulationWire) {
            if (checkConnection(world, neighbor, visited)) return true;
        }
    }
    return false;
}