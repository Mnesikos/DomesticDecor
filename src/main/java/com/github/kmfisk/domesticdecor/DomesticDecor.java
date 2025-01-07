package com.github.kmfisk.domesticdecor;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DomesticDecor.MOD_ID)
public class DomesticDecor {
    public static final String MOD_ID = "domesticdecor";

    public static final ItemGroup GROUP = new ItemGroup(DomesticDecor.MOD_ID + ".domestic_decor_group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DecorItems.WHITE_EGG.get());
        }
    };

    public DomesticDecor() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
