package com.github.kmfisk.domesticdecor.block;

import com.github.kmfisk.domesticdecor.DomesticDecor;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public abstract class BlockBaseColored extends BlockBase {
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public BlockBaseColored(String name, Material material) {
        super(name, material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(COLOR, EnumDyeColor.WHITE));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return (state.getValue(COLOR)).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (EnumDyeColor enumdyecolor : EnumDyeColor.values())
            items.add(new ItemStack(this, 1, enumdyecolor.getMetadata()));
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.getBlockColor(state.getValue(COLOR));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3)).withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | (state.getValue(FACING)).getHorizontalIndex();
        i = i | (state.getValue(COLOR)).getMetadata();
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, COLOR);
    }

    public void registerItemModel(Item itemBlock, int subType, String id) {
        DomesticDecor.PROXY.registerItemRenderer(itemBlock, subType, id);
    }

    public Item createItemBlock() {
        return new ItemCloth(this).setUnlocalizedName(getUnlocalizedName());
    }
}
