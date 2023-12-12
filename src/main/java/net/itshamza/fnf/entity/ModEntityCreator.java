package net.itshamza.fnf.entity;

import net.itshamza.fnf.FloraNFauna;
import net.itshamza.fnf.entity.client.CaimanModel;
import net.itshamza.fnf.entity.client.CaimanRenderer;
import net.itshamza.fnf.entity.custom.CaimanEntity;
import net.itshamza.fnf.entity.layer.ModModelLayers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = FloraNFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityCreator {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FloraNFauna.MOD_ID);

    //REGISTRIES

    public static final RegistryObject<EntityType<CaimanEntity>> CAIMAN =
            ENTITY_TYPES.register("caiman", () -> EntityType.Builder.of(CaimanEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1f).build("caiman"));

    //RENDERERS

    @SubscribeEvent
    public static void registerEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityCreator.CAIMAN.get(), CaimanRenderer::new);
    }

    //LAYERS

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, CaimanModel::createBodyLayer);
    }

    //ATTRIBUTES

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityCreator.CAIMAN.get(), CaimanEntity.createAttributes().build());
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
