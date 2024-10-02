package net.badnuker.testmod.datagen;

import net.badnuker.testmod.block.ModBlocks;
import net.badnuker.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {
    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.CRYSTAL, "水晶");

        translationBuilder.add(ModBlocks.CRYSTAL_BLOCK, "水晶块");
        translationBuilder.add(ModBlocks.CRYSTAL_ORE, "水晶矿石");

        translationBuilder.add("itemGroup.test_group", "测试物品");

    }
}
