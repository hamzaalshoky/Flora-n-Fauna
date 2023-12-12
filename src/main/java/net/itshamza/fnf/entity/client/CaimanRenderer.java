package net.itshamza.fnf.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.itshamza.fnf.FloraNFauna;
import net.itshamza.fnf.entity.custom.CaimanEntity;
import net.itshamza.fnf.entity.layer.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CaimanRenderer extends MobRenderer<CaimanEntity, CaimanModel<CaimanEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(FloraNFauna.MOD_ID,"textures/entity/caiman/caiman.png");

    public CaimanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CaimanModel<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(CaimanEntity pEntity) {
        return LOCATION;
    }

    @Override
    public void render(CaimanEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
