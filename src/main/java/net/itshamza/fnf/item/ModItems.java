package net.itshamza.fnf.item;

import net.itshamza.fnf.FloraNFauna;
import net.itshamza.fnf.entity.ModEntityCreator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FloraNFauna.MOD_ID);

    //public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
    //       () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAIMAN_SPAWN_EGG = ITEMS.register("caiman_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityCreator.CAIMAN, 8953179, 4932160,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
