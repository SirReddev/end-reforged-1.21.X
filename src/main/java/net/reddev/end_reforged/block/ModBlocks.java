package net.reddev.end_reforged.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.reddev.end_reforged.EndReforged;

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

        });
    }
}
