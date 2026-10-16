package net.poison.poisonmod.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.poison.poisonmod.PoisonMod;
import net.poison.poisonmod.block.ModBlocks;
import net.poison.poisonmod.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, PoisonMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.AZURITA.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.P_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_AZURITA.get(), ModelTemplates.FLAT_ITEM);

        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.AZURITA_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.AZURITA_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITA_END_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITA_NETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITA_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_AZURITA_BLOCK.get());
    }
}
