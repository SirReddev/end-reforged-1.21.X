package net.reddev.end_reforged;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.report.BiomeParametersProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.reddev.end_reforged.datagen.ModBlockTagProvider;
import net.reddev.end_reforged.datagen.ModModelProvider;
import net.reddev.end_reforged.datagen.ModWorldGenerator;
import net.reddev.end_reforged.world.ModConfiguredFeatures;
import net.reddev.end_reforged.world.ModPlacedFeatures;
import net.reddev.end_reforged.world.biome.ModBiomes;

public class EndReforgedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModBlockTagProvider::new);
//      pack.addProvider(ModItemsTagProvider::new); NO ITEM TAGS USED YET
//      pack.addProvider(ModLootTableProvider::new); NO LOOTTABLE USED YET
        pack.addProvider(ModModelProvider::new);
//      pack.addProvider(ModRecipeProvider::new); NO SIMPEL BLOCK MODELS USED YET

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);

    }
}
