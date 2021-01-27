package com.github.kmfisk.domesticdecor.init;

import com.github.kmfisk.domesticdecor.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class DDBlocks {
    public static final BlockAnimalHut ANIMAL_HUT = new BlockAnimalHut("animal_hut", Material.CLOTH);
    public static final BlockBirdFeeder BIRD_FEEDER = new BlockBirdFeeder("bird_feeder", Material.WOOD);
    public static final BlockBirdHouse BIRD_HOUSE = new BlockBirdHouse("bird_house", Material.WOOD);
    public static final BlockBucket BUCKET = new BlockBucket("bucket", Material.IRON);
    public static final BlockCarrier CARRIER = new BlockCarrier("carrier", Material.CIRCUITS);
    public static final BlockChickenFeeder CHICKEN_FEEDER = new BlockChickenFeeder("chicken_feeder", Material.CIRCUITS);
    public static final BlockChickenWaterer CHICKEN_WATERER = new BlockChickenWaterer("chicken_waterer", Material.CIRCUITS);
    public static final BlockChickFeeder CHICK_FEEDER = new BlockChickFeeder("chick_feeder", Material.CIRCUITS);
    public static final BlockChickWaterer CHICK_WATERER = new BlockChickWaterer("chick_waterer", Material.CIRCUITS);
    public static final BlockDoubleBowl DOUBLE_BOWL = new BlockDoubleBowl("double_bowl", Material.CIRCUITS);
    public static final BlockFoodBowl FOOD_BOWL = new BlockFoodBowl("food_bowl", Material.CIRCUITS);
    public static final BlockSaddleStand SADDLE_STAND = new BlockSaddleStand("saddle_stand", Material.WOOD);
    public static final BlockWaterBowl WATER_BOWL = new BlockWaterBowl("water_bowl", Material.CIRCUITS);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                ANIMAL_HUT,
                BIRD_FEEDER,
                BIRD_HOUSE,
                BUCKET,
                CARRIER,
                CHICKEN_FEEDER,
                CHICKEN_WATERER,
                CHICK_FEEDER,
                CHICK_WATERER,
                DOUBLE_BOWL,
                FOOD_BOWL,
                SADDLE_STAND,
                WATER_BOWL
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                ANIMAL_HUT.createItemBlock(),
                BIRD_FEEDER.createItemBlock(),
                BIRD_HOUSE.createItemBlock(),
                BUCKET.createItemBlock(),
                CARRIER.createItemBlock(),
                CHICKEN_FEEDER.createItemBlock(),
                CHICKEN_WATERER.createItemBlock(),
                CHICK_FEEDER.createItemBlock(),
                CHICK_WATERER.createItemBlock(),
                DOUBLE_BOWL.createItemBlock(),
                FOOD_BOWL.createItemBlock(),
                SADDLE_STAND.createItemBlock(),
                WATER_BOWL.createItemBlock()
        );
    }

    public static void registerModels() {
        ANIMAL_HUT.registerItemModel(Item.getItemFromBlock(ANIMAL_HUT));
        BIRD_FEEDER.registerItemModel(Item.getItemFromBlock(BIRD_FEEDER));
        BIRD_HOUSE.registerItemModel(Item.getItemFromBlock(BIRD_HOUSE));
        BUCKET.registerItemModel(Item.getItemFromBlock(BUCKET));
        CARRIER.registerItemModel(Item.getItemFromBlock(CARRIER));
        CHICKEN_FEEDER.registerItemModel(Item.getItemFromBlock(CHICKEN_FEEDER));
        CHICKEN_WATERER.registerItemModel(Item.getItemFromBlock(CHICKEN_WATERER));
        CHICK_FEEDER.registerItemModel(Item.getItemFromBlock(CHICK_FEEDER));
        CHICK_WATERER.registerItemModel(Item.getItemFromBlock(CHICK_WATERER));
        DOUBLE_BOWL.registerItemModel(Item.getItemFromBlock(DOUBLE_BOWL));
        FOOD_BOWL.registerItemModel(Item.getItemFromBlock(FOOD_BOWL));
        SADDLE_STAND.registerItemModel(Item.getItemFromBlock(SADDLE_STAND));
        WATER_BOWL.registerItemModel(Item.getItemFromBlock(WATER_BOWL));
    }
}
