package com.github.kmfisk.domesticdecor;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DomesticDecor.MODID, name = DomesticDecor.NAME, version = DomesticDecor.VERSION)
public class DomesticDecor {
    public static final String MODID = "domesticdecor";
    public static final String NAME = "Domestic Decor";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}