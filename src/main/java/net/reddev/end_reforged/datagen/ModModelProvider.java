package net.reddev.end_reforged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.reddev.end_reforged.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    // Blocks that use a **single texture** on all faces
    private static final Block[] SINGLE_TEXTURE_BLOCKS = new Block[] {
            ModBlocks.END_MOSS_BLOCK,
            ModBlocks.DEEP_END_SLATE_BLOCK,
            ModBlocks.GREEN_END_ROCK_BLOCK,
            ModBlocks.DEEP_GREEN_END_ROCK_BLOCK,
            ModBlocks.END_SLATE_BLOCK

    };

    // Blocks that use separate textures for top, bottom, side
    private static final Block[] TOP_BOTTOM_SIDE_BLOCKS = new Block[] {
            ModBlocks.END_NYLIUM_BLOCK,
            ModBlocks.LAYERED_END_ROCK_BLOCK,
            ModBlocks.DEEP_LAYERED_END_ROCK_BLOCK
    };

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        // Single texture blocks – use simple cube all
        for (Block block : SINGLE_TEXTURE_BLOCKS) {
            generator.registerSimpleCubeAll(block);
        }

        // Blocks with top/bottom/side textures
        for (Block block : TOP_BOTTOM_SIDE_BLOCKS) {
            registerCubeBottomTopBlock(generator, block);
        }
    }

    private void registerCubeBottomTopBlock(BlockStateModelGenerator generator, Block block) {
        Identifier blockId = Registries.BLOCK.getId(block);
        String path = blockId.getPath();    // e.g., "end_nylium_block"
        String modId = blockId.getNamespace();

        String baseName = path.substring(0, path.lastIndexOf("_block"));

        Identifier top    = Identifier.of(modId, "block/" + baseName + "_top");
        Identifier bottom = Identifier.of(modId, "block/" + baseName + "_bottom");
        Identifier side   = Identifier.of(modId, "block/" + baseName + "_side");

        // Custom upload since there's no direct helper for bottom/top/side in BlockStateModelGenerator
        final Identifier modelId = Models.CUBE_BOTTOM_TOP.upload(
                block,
                new net.minecraft.data.client.TextureMap()
                        .put(net.minecraft.data.client.TextureKey.TOP,    top)
                        .put(net.minecraft.data.client.TextureKey.BOTTOM, bottom)
                        .put(net.minecraft.data.client.TextureKey.SIDE,   side)
                        .put(net.minecraft.data.client.TextureKey.PARTICLE, side),
                generator.modelCollector
        );

        generator.blockStateCollector.accept(
                net.minecraft.data.client.VariantsBlockStateSupplier.create(block,
                        net.minecraft.data.client.BlockStateVariant.create().put(
                                net.minecraft.data.client.VariantSettings.MODEL, modelId))
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Removed item model generation code.
    }

    @Override
    public String getName() {
        return "EndReforged Model Provider";
    }
}