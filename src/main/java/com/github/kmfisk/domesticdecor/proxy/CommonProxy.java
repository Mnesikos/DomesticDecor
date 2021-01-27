package com.github.kmfisk.domesticdecor.proxy;

import com.github.kmfisk.domesticdecor.DomesticDecor;
import com.github.kmfisk.domesticdecor.init.DDBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CommonProxy {
    public final CreativeTabs DOMESTICDECOR = new CreativeTabs(DomesticDecor.MOD_ID + ".tab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(DDBlocks.BIRD_FEEDER);
        }
    };

    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
