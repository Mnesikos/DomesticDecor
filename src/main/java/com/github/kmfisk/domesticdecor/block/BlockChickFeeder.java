package com.github.kmfisk.domesticdecor.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockChickFeeder extends BlockBaseDirectional {
    public BlockChickFeeder(String name, Material material) {
        super(name, material);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return null;
    }
}
