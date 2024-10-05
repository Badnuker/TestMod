package net.badnuker.testmod.datagen;

import net.badnuker.testmod.block.ModBlocks;
import net.badnuker.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> CRYSTAL = List.of(Items.DIAMOND);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CRYSTAL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDER_DAGGER)
                .input('#', Items.BLAZE_ROD)
                .input('X', Items.ENDER_PEARL)
                .pattern("X")
                .pattern("#")
                .criterion("has_ender_pearl", conditionsFromItem(Items.ENDER_PEARL))
                .offerTo(exporter);

        offerSmelting(exporter, CRYSTAL, RecipeCategory.MISC, ModItems.CRYSTAL, 0.7f, 200, "crystal");
        offerBlasting(exporter, CRYSTAL, RecipeCategory.MISC, ModItems.CRYSTAL, 0.7f, 100, "crystal");
    }
}
