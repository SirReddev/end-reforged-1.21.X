package net.reddev.end_reforged.world;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer; // 👈 Used for wide, sprawling crown
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;

import net.reddev.end_reforged.EndReforged;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.reddev.end_reforged.block.ModBlocks;

public class ModConfiguredFeatures {

    // Using the key name from your latest paste
    public static RegistryKey<ConfiguredFeature<?, ?>> CHORUSWOOD_KEY = registerKey("chorus_tree");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        // Configuration using BendingTrunkPlacer and LargeOakFoliagePlacer
        register(context, CHORUSWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHORUS_LOG_BLOCK),
                // BendingTrunkPlacer: Thick, curving trunk for a unique structure
                new BendingTrunkPlacer(
                        8, // Base height (Taller)
                        4, // Random height offset
                        7, // Bend length (More curve)
                        3, // Min height before it can start bending
                        UniformIntProvider.create(1, 2) // Number of bends/branches
                ),
                BlockStateProvider.of(ModBlocks.CHORUS_LEAVES_BLOCK),
                // LargeOakFoliagePlacer: Creates a dense, irregular, and spreading crown
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2), // Radius (Wider crown)
                        ConstantIntProvider.create(4),
                        10// Offset (Starts leaves lower on the trunk)
                ),
                // TwoLayersFeatureSize: Standard feature size for a basic tree structure.
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        // Assuming EndReforged.MOD_ID is defined and used for the Identifier
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EndReforged.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}