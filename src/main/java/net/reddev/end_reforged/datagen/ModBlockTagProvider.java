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
                .add(ModBlocks.LAYERED_END_ROCK_BLOCK)
                .add(ModBlocks.CHORUS_LEAVES_VARIANT_BLOCK)
                .add(ModBlocks.CHORUS_LEAVES_OUTER_BLOCK)
                .add(ModBlocks.CHORUS_LEAVES_BLOCK);


        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHORUS_LOG_BLOCK)
                .add(ModBlocks.CHORUS_WOOD_BLOCK)
                .add(ModBlocks.CHORUS_LOG_VARIANT1_BLOCK)
                .add(ModBlocks.CHORUS_LOG_VARIANT2_BLOCK)
                .add(ModBlocks.CHORUS_WOOD_VARIANT1_BLOCK)
                .add(ModBlocks.CHORUS_WOOD_VARIANT2_BLOCK);

    }
}