package net.itshamza.fnf.item;

import net.itshamza.fnf.FloraNFauna;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FloraNFauna.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FNF_TAB = CREATIVE_MODE_TABS.register("fnf_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAIMAN_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.fnf_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.CAIMAN_SPAWN_EGG.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
