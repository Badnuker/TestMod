package net.badnuker.testmod.item;

import net.badnuker.testmod.TestMod;
import net.badnuker.testmod.item.custom.EnderSword;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item CRYSTAL = registerItems("crystal", new Item(new Item.Settings()));
    public static final Item ENDER_DAGGER = registerItems(
            "ender_dagger",
            new EnderSword(new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .maxDamage(16)
                    .attributeModifiers(EnderSword.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, EnderSword.createToolComponent()))
    );

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, id), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Items");
    }
}
