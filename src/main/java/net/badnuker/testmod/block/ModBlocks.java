package net.badnuker.testmod.block;

import net.badnuker.testmod.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block CRYSTAL_BLOCK = register(
            "crystal_block",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(5.0F, 6.0F))
    );
    public static final Block CRYSTAL_ORE = register(
            "crystal_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().requiresTool().strength(3.0F, 3.0F)
            )
    );

    public static void registerBlockItems(String id, Block block) {
        BlockItem item = Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, id), block);
    }

    private static void addBuildingBlocks(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(CRYSTAL_BLOCK);
    }

    private static void addNatural(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(CRYSTAL_ORE);
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addNatural);
        TestMod.LOGGER.info("Registering Blocks");
    }
}
