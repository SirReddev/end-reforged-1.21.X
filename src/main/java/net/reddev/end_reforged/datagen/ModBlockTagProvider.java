package net.reddev.end_reforged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.reddev.end_reforged.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEP_END_SLATE_BLOCK)
                .add(ModBlocks.END_SLATE_BLOCK)
                .add(ModBlocks.END_NYLIUM_BLOCK)
                .add(ModBlocks.DEEP_GREEN_END_ROCK_BLOCK)
                .add(ModBlocks.DEEP_LAYERED_END_ROCK_BLOCK)
                .add(ModBlocks.END_MOSS_BLOCK)
                .add(ModBlocks.GREEN_END_ROCK_BLOCK)
                .add(ModBlocks.LAYERED_END_ROCK_BLOCK);


    }
}