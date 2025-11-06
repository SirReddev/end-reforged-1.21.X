package net.reddev.end_reforged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.reddev.end_reforged.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
        //  .add(ModItems.END_SLATE_BLOCK)


        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHORUS_LOG_BLOCK.asItem())
                .add(ModBlocks.CHORUS_WOOD_BLOCK.asItem())
                .add(ModBlocks.CHORUS_LOG_VARIANT1_BLOCK.asItem())
                .add(ModBlocks.CHORUS_LOG_VARIANT2_BLOCK.asItem())
                .add(ModBlocks.CHORUS_WOOD_VARIANT1_BLOCK.asItem())
                .add(ModBlocks.CHORUS_WOOD_VARIANT2_BLOCK.asItem());
    }
}