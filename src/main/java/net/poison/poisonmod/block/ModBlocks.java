package net.poison.poisonmod.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.poison.poisonmod.PoisonMod;
import net.poison.poisonmod.item.ModItems;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PoisonMod.MOD_ID);

    //public static final DeferredBlock<Block> AZURITA_BLOCK = registerBlock("azurita_block", properties -> new Block(properties));
    public static final DeferredBlock<Block> AZURITA_BLOCK = registerBlock("azurita_block",
            properties -> new Block(properties.strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.IRON)));

    // TODO: ADD LIGHTLEVEL TO AZURITA ORE
    public static final DeferredBlock<Block> AZURITA_ORE = registerBlock("azurita_ore",
            properties -> new Block(properties.strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    // you can use.noLoot.Table() method
    public static final DeferredBlock<Block> AZURITA_DEEPSLATE_ORE = registerBlock("azurita_deepslate_ore",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> AZURITA_END_ORE = registerBlock("azurita_end_ore",
            properties -> new Block(properties.strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> AZURITA_NETHER_ORE = registerBlock("azurita_nether_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties.strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)));

    public static final DeferredBlock<Block> RAW_AZURITA_BLOCK = registerBlock("raw_azurita_block",
            properties -> new Block(properties.strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.IRON)));


    public static ResourceKey<Block> getRK(Block block){
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function){
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}