package net.reddev.end_reforged.world.biome;

import net.reddev.end_reforged.EndReforged;
import net.reddev.end_reforged.world.biome.surface.ModMaterialRules;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        // FIX: The Overworld Region registration is REMOVED to prevent Overworld generation.
        // Regions.register(new ModOverworldRegion(Identifier.of(EndReforged.MOD_ID, "end"), 4));

        // 1. Register Surface Rules for the END
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, EndReforged.MOD_ID, ModMaterialRules.makeRules());

        // 2. Inject the custom biome into the End Highlands (FIX for NullPointerException)
        EndBiomeRegistry.registerHighlandsBiome(ModBiomes.END_WILDS, 100);
        EndBiomeRegistry.registerMidlandsBiome(ModBiomes.END_WILDS, 100);
        EndBiomeRegistry.registerEdgeBiome(ModBiomes.END_WILDS, 100);



    }
}