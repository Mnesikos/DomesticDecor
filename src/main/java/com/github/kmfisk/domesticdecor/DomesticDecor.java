package com.github.kmfisk.domesticdecor;

import com.github.kmfisk.domesticdecor.init.DDBlocks;
import com.github.kmfisk.domesticdecor.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = DomesticDecor.MOD_ID, name = "Domestic Decor", version = DomesticDecor.VERSION)
public class DomesticDecor {
    public static final String MOD_ID = "domesticdecor";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(clientSide="com.github.kmfisk.domesticdecor.proxy.ClientProxy", serverSide="com.github.kmfisk.domesticdecor.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            DDBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            DDBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            DDBlocks.registerModels();
        }
    }
}
