package net.reddev.end_reforged.datagen;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.reddev.end_reforged.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModDirectionalBlockModelProvider {

    // Logs and corresponding wood blocks (must match by index)
    public static final Block[] LOG_BLOCKS = new Block[]{
            ModBlocks.CHORUS_LOG_BLOCK,
            ModBlocks.CHORUS_LOG_VARIANT1_BLOCK,
            ModBlocks.CHORUS_LOG_VARIANT2_BLOCK
    };

    public static final Block[] WOOD_BLOCKS = new Block[]{
            ModBlocks.CHORUS_WOOD_BLOCK,
            ModBlocks.CHORUS_WOOD_VARIANT1_BLOCK,
            ModBlocks.CHORUS_WOOD_VARIANT2_BLOCK
    };
    private static final Logger log = LoggerFactory.getLogger(ModDirectionalBlockModelProvider.class);

    /**
     * Registers all logs and their corresponding wood blocks.
     */
    public static void registerAllPillarModels(BlockStateModelGenerator generator) {
        for (int i = 0; i < LOG_BLOCKS.length; i++) {
            registerLogAndWoodPair(generator, LOG_BLOCKS[i], WOOD_BLOCKS[i]);
        }
    }

    /**
     * Registers a single log block with side and top textures, plus its wood block.
     */
    private static void registerLogAndWoodPair(BlockStateModelGenerator generator, Block logBlock, Block woodBlock) {
        // Register log with explicit textures and automatically generate the wood block
        generator.registerLog(logBlock)
                .wood(woodBlock)
                .log(logBlock);
    }
}
