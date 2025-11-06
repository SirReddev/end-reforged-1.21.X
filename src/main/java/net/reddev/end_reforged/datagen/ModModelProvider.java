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
            ModBlocks.END_SLATE_BLOCK,
            ModBlocks.CHORUS_LEAVES_VARIANT_BLOCK,
            ModBlocks.CHORUS_LEAVES_OUTER_BLOCK,
            ModBlocks.CHORUS_LEAVES_BLOCK,
    };

    // Blocks that use separate textures for top, bottom, side, BUT ARE **NOT** PILLARS/LOGS
    private static final Block[] CUBE_BOTTOM_TOP_BLOCKS = new Block[] {
            ModBlocks.END_NYLIUM_BLOCK,
            ModBlocks.LAYERED_END_ROCK_BLOCK,
            ModBlocks.DEEP_LAYERED_END_ROCK_BLOCK
    };

    // --- NEW: Define your sapling blocks here ---
    private static final Block[] SAPLING_BLOCKS = new Block[] {
            ModBlocks.CHORUS_SAPLING, // Replace with your actual sapling block references
    };
    // ---------------------------------------------

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        // Simple cube-all blocks
        for (Block block : SINGLE_TEXTURE_BLOCKS) {
            generator.registerSimpleCubeAll(block);
        }

        // Cube Bottom Top blocks
        for (Block block : CUBE_BOTTOM_TOP_BLOCKS) {
            registerCubeBottomTopBlock(generator, block);
        }

        // Sapling blocks: Delegate to the new sapling provider
        for (Block block : SAPLING_BLOCKS) {
            registerSaplingBlock(generator, block);
        }

        // LOG BLOCKS: Delegate to the dedicated directional provider class
        ModDirectionalBlockModelProvider.registerAllPillarModels(generator);
    }

    // Helper method for Blocks that use the standard CUBE_BOTTOM_TOP model (like Grass/Nylium)
    private void registerCubeBottomTopBlock(BlockStateModelGenerator generator, Block block) {
        Identifier blockId = Registries.BLOCK.getId(block);
        String path = blockId.getPath();
        String modId = blockId.getNamespace();

        String baseName = path.substring(0, path.lastIndexOf("_block"));

        Identifier top    = Identifier.of(modId, "block/" + baseName + "_top");
        Identifier bottom = Identifier.of(modId, "block/" + baseName + "_bottom");
        Identifier side   = Identifier.of(modId, "block/" + baseName + "_side");

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

    // --- NEW: Helper method for Sapling blocks ---
    private void registerSaplingBlock(BlockStateModelGenerator generator, Block block) {
        // This helper method provided by Fabric handles both the blockstate and the item model.
        // It uses the standard 'cross' model and expects a texture named "block/[block_id_path]"
        // in your assets folder.
        generator.registerTintableCross(block, BlockStateModelGenerator.TintType.NOT_TINTED);
    }
    // ---------------------------------------------

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    @Override
    public String getName() {
        return "EndReforged Model Provider";
    }
}
