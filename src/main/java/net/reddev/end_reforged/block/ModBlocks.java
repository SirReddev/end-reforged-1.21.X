package net.reddev.end_reforged.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.reddev.end_reforged.EndReforged;
import net.reddev.end_reforged.world.tree.ModSaplingGenerators;

public class ModBlocks {

    public static final Block END_SLATE_BLOCK = registerBlock("end_slate_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block END_NYLIUM_BLOCK = registerBlock("end_nylium_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEP_END_SLATE_BLOCK = registerBlock("deep_end_slate_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block GREEN_END_ROCK_BLOCK = registerBlock("green_end_rock_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEP_GREEN_END_ROCK_BLOCK = registerBlock("deep_green_end_rock_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));


    public static final Block LAYERED_END_ROCK_BLOCK = registerBlock("layered_end_rock_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEP_LAYERED_END_ROCK_BLOCK = registerBlock("deep_layered_end_rock_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block END_MOSS_BLOCK = registerBlock("end_moss_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.MOSS_BLOCK)));
    // CHORUS LEAVE BLOCKS
    public static final Block CHORUS_LEAVES_BLOCK = registerBlock("chorus_leaves_block",
            new Block(AbstractBlock.Settings.create()
                    .nonOpaque()
                    .luminance(value -> 15)
                    .sounds(BlockSoundGroup.GRASS)));

    public static final Block CHORUS_LEAVES_VARIANT_BLOCK = registerBlock("chorus_leaves_variant_block",
            new Block(AbstractBlock.Settings.create()
                    .nonOpaque()
                    .luminance(value -> 15)
                    .sounds(BlockSoundGroup.GRASS)));

    public static final Block CHORUS_LEAVES_OUTER_BLOCK = registerBlock("chorus_leaves_outer_block",
            new Block(AbstractBlock.Settings.create()
                    .nonOpaque()
                    .luminance(value -> 15)
                    .sounds(BlockSoundGroup.GRASS)));
    public static final Block CHORUS_SAPLING = registerBlock("chorus_sapling",
            new net.reddev.end_reforged.block.ChorusSaplingBlock(ModSaplingGenerators.CHORUSWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    // CHORUS LOG AND WOOD BLOCKS
    public static final Block CHORUS_WOOD_BLOCK = registerBlock("chorus_wood_block",
            new RotatablePillarBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CHORUS_WOOD_VARIANT1_BLOCK = registerBlock("chorus_wood_variant1_block",
            new RotatablePillarBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CHORUS_WOOD_VARIANT2_BLOCK = registerBlock("chorus_wood_variant2_block",
            new RotatablePillarBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CHORUS_LOG_BLOCK = registerBlock("chorus_log_block",
            new RotatablePillarBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CHORUS_LOG_VARIANT1_BLOCK = registerBlock("chorus_log_variant1_block",
            new RotatablePillarBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CHORUS_LOG_VARIANT2_BLOCK = registerBlock("chorus_log_variant2_block",
            new RotatablePillarBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.CHERRY_WOOD)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EndReforged.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EndReforged.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        EndReforged.LOGGER.info("Registering ModBlocks for " + EndReforged.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.END_SLATE_BLOCK);
            entries.add(ModBlocks.END_NYLIUM_BLOCK);
            entries.add(ModBlocks.DEEP_END_SLATE_BLOCK);
            entries.add(ModBlocks.GREEN_END_ROCK_BLOCK);
            entries.add(ModBlocks.DEEP_GREEN_END_ROCK_BLOCK);
            entries.add(ModBlocks.END_MOSS_BLOCK);
            entries.add(ModBlocks.LAYERED_END_ROCK_BLOCK);
            entries.add(ModBlocks.DEEP_LAYERED_END_ROCK_BLOCK);
            entries.add(ModBlocks.CHORUS_LOG_BLOCK);
            entries.add(ModBlocks.CHORUS_WOOD_BLOCK);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.CHORUS_LEAVES_BLOCK);
        });
    }
}