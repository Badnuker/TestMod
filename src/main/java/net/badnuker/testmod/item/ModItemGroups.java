package net.badnuker.testmod.item;

import net.badnuker.testmod.TestMod;
import net.badnuker.testmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TEST_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TestMod.MOD_ID, "test_group"),
            ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.test_group"))
                    .icon(() -> new ItemStack(ModItems.CRYSTAL))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CRYSTAL);
                        entries.add(ModBlocks.CRYSTAL_BLOCK);
                        entries.add(ModBlocks.CRYSTAL_ORE);
                        entries.add(ModItems.ENDER_DAGGER);
                    }).build());

    public static void registerModItemsGroups() {
        TestMod.LOGGER.info("Registering Item Groups");
    }
}
