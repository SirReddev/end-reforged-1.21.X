package net.reddev.end_reforged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.reddev.end_reforged.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // --- End Blocks (Standard Drop: Block itself) ---
        this.addDrop(ModBlocks.END_NYLIUM_BLOCK);
        this.addDrop(ModBlocks.END_SLATE_BLOCK);
        this.addDrop(ModBlocks.DEEP_END_SLATE_BLOCK);
        this.addDrop(ModBlocks.GREEN_END_ROCK_BLOCK);
        this.addDrop(ModBlocks.DEEP_GREEN_END_ROCK_BLOCK);
        this.addDrop(ModBlocks.LAYERED_END_ROCK_BLOCK);
        this.addDrop(ModBlocks.DEEP_LAYERED_END_ROCK_BLOCK);
        this.addDrop(ModBlocks.END_MOSS_BLOCK);

// --- Log Blocks (Standard Drop: Block itself) ---
        this.addDrop(ModBlocks.CHORUS_LOG_BLOCK);
        this.addDrop(ModBlocks.CHORUS_LOG_VARIANT1_BLOCK);
        this.addDrop(ModBlocks.CHORUS_LOG_VARIANT2_BLOCK);

// --- Wood Blocks (Standard Drop: Block itself) ---
        this.addDrop(ModBlocks.CHORUS_WOOD_BLOCK);
        this.addDrop(ModBlocks.CHORUS_WOOD_VARIANT1_BLOCK);
        this.addDrop(ModBlocks.CHORUS_WOOD_VARIANT2_BLOCK);

// --- Special Case: Leaves (Need SHEARS_ONLY or specific items) ---
        this.addDrop(ModBlocks.CHORUS_LEAVES_BLOCK, dropsWithShears(ModBlocks.CHORUS_LEAVES_BLOCK));
        this.addDrop(ModBlocks.CHORUS_LEAVES_OUTER_BLOCK, dropsWithShears(ModBlocks.CHORUS_LEAVES_BLOCK));
        this.addDrop(ModBlocks.CHORUS_LEAVES_VARIANT_BLOCK, dropsWithShears(ModBlocks.CHORUS_LEAVES_BLOCK));

        // addDrop(ModBlocks.ORE, oreDrops(ModBlocks.ore_drop));
        // addDrop(ModBlocks.ORE, multipleOreDrops(ModBlocks.ORE, ModItems.ORE, 3, 7)); SEE BELOW

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}