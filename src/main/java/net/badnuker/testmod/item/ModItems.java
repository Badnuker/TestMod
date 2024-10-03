package net.badnuker.testmod.item;

import net.badnuker.testmod.TestMod;
import net.badnuker.testmod.item.custom.EnderSword;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CRYSTAL = registerItems("crystal", new Item(new Item.Settings()));
    public static final Item ENDER_SWORD = registerItems(
            "ender_sword",
            new EnderSword(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4F)))
    );

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, id), item);
    }

    private static void addIngredients(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(CRYSTAL);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addIngredients);
        TestMod.LOGGER.info("Registering Items");
    }
}
