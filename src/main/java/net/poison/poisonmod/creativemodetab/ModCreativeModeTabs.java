package net.poison.poisonmod.creativemodetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.poison.poisonmod.PoisonMod;
import net.poison.poisonmod.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PoisonMod.MOD_ID);

    public static final Supplier<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TABS.register("items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITA.get()))
                    .title(Component.translatable("creativetab.poisonmod.items"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(PoisonMod.MOD_ID, "blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AZURITA);
                        output.accept(ModItems.RAW_AZURITA);
                        output.accept(ModItems.P_POWDER);
                    }).build());


    public static final Supplier<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITA.get()))
                    .title(Component.translatable("creativetab.poisonmod.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
