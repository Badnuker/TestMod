package net.badnuker.testmod;

import net.badnuker.testmod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelsProvider::new);
        pack.addProvider(ModRecipesProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModBlocksTagsProvider::new);
        pack.addProvider(ModItemsTagsProvider::new);
        pack.addProvider(ModZHCNLanProvider::new);
        pack.addProvider(ModENUSLanProvider::new);
    }
}
