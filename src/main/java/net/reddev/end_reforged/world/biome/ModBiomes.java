package net.reddev.end_reforged.world.biome;

import net.reddev.end_reforged.EndReforged;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.EndPlacedFeatures; // FIXED: Correct import for End Gateway

public class ModBiomes {

    // FIX: Standardizing the key name to END_WILD across the mod
    public static final RegistryKey<Biome> END_WILDS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(EndReforged.MOD_ID, "end_wilds"));

    /**
     * Called by the Fabric Data Generator (runData) to register the biome definition.
     */
    public static void bootstrap(Registerable<Biome> context) {
        // FIX: Passes the context to the creation method.
        context.register(END_WILDS, createEndWildBiome(context));
    }

    /**
     * FIX: Adds ONLY End terrain features (REMOVED all Overworld features).
     */
    public static void globalENDGeneration(GenerationSettings.LookupBackedBuilder builder) {
        // FIX: Correctly referencing the End Gateway return feature key
        builder.feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN);

        // Example End decoration. You can add more custom features here.
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EndPlacedFeatures.CHORUS_PLANT);

        DefaultBiomeFeatures.addFossils(builder);
    }

    /**
     * Creates the custom End Wild biome definition.
     */
    public static Biome createEndWildBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        // FIX: Using End-specific mob spawns
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 5, 4, 4));
        DefaultBiomeFeatures.addEndMobs(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        // Use the End generation features
        globalENDGeneration(biomeBuilder);

        // Biome visual effects
        BiomeEffects effects = new BiomeEffects.Builder()
                .waterColor(0xe82e3b)
                .waterFogColor(0xbf1b26)
                .skyColor(0x30c918)
                .grassColor(0x7f03fc)
                .foliageColor(0xd203fc)
                .fogColor(0x22a1e6)
                .moodSound(BiomeMoodSound.CAVE)
                .build();

        return new Biome.Builder()
                .precipitation(false) // FIXED: No rain in the End
                .downfall(0f)         // FIXED: No downfall in the End
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(effects)
                .build();
    }
}