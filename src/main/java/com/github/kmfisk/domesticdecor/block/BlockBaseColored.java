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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.*;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockBaseColored extends BlockBase {
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public BlockBaseColored(String name, Material material) {
        super(name, material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(COLOR, EnumDyeColor.WHITE));
    }

    @Override
    public int damageDropped(IBlockState state) {
        EnumDyeColor enumColour = state.getValue(COLOR);
        return enumColour.getMetadata();
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
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        int colourbits = (meta & 0x0c) >> 2;
        EnumDyeColor colour = EnumDyeColor.byMetadata(colourbits);
        return this.getDefaultState().withProperty(COLOR, colour).withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing facing = state.getValue(FACING);
        EnumDyeColor color = state.getValue(COLOR);

        int facingbits = facing.getHorizontalIndex();
        int colorbits = color.getMetadata() << 2;
        return facingbits | colorbits;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, COLOR);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        EnumDyeColor colour = EnumDyeColor.byMetadata(meta);
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

        return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(COLOR, colour);
    }

    public void registerItemModel(Item itemBlock, int subType, String id) {
        DomesticDecor.proxy.registerItemRenderer(itemBlock, subType, id);
    }

    public Item createItemBlock() {
        return new ItemCloth(this).setRegistryName(getRegistryName());
    }
}
