package net.badnuker.testmod.datagen;

import net.badnuker.testmod.block.ModBlocks;
import net.badnuker.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.CRYSTAL, "Crystal");
        translationBuilder.add(ModItems.ENDER_SWORD, "Ender Sword");

        translationBuilder.add(ModBlocks.CRYSTAL_BLOCK, "Crystal Block");
        translationBuilder.add(ModBlocks.CRYSTAL_ORE, "Crystal Ore");

        translationBuilder.add("itemGroup.test_group", "Test Group");
    }
}
