package net.itshamza.fnf.entity.client;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.itshamza.fnf.entity.animations.ModAnimationDefinitions;
import net.itshamza.fnf.entity.custom.CaimanEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class CaimanModel<T extends CaimanEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("fnf", "caimanmodel"), "main");
	private final ModelPart caiman;

	public CaimanModel(ModelPart root) {
		this.caiman = root.getChild("caiman");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition caiman = partdefinition.addOrReplaceChild("caiman", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition body = caiman.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -16.0F, 10.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 6.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(64, 14).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -16.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 0).addBox(-4.5F, -2.0F, -5.0F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 66).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(42, 14).addBox(-3.5F, -5.0F, -5.0F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 14).addBox(-3.5F, -3.0F, -16.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(29, 30).addBox(-3.5F, -2.0F, -16.0F, 7.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(43, 30).addBox(-3.5F, 0.0F, -16.0F, 7.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(60, 58).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 53).addBox(-3.0F, -1.0F, -14.0F, 6.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(54, 46).addBox(-2.5F, -3.0F, -14.0F, 5.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -1.0F));

		PartDefinition armcore = body.addOrReplaceChild("armcore", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -12.0F));

		PartDefinition armleft = armcore.addOrReplaceChild("armleft", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(-3.0F, 5.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition armright = armcore.addOrReplaceChild("armright", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-3.0F, -2.0F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 8).mirror().addBox(-5.0F, 5.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 6.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(42, 0).addBox(-3.0F, -4.0F, 4.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 7.0F));

		PartDefinition tail2 = body.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(34, 46).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(0.0F, -1.0F, 11.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(65, 32).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 24.0F));

		PartDefinition legcore = caiman.addOrReplaceChild("legcore", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 9.0F));

		PartDefinition legleft = legcore.addOrReplaceChild("legleft", CubeListBuilder.create().texOffs(25, 63).addBox(-2.4F, -2.0F, -5.0F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(51, 67).addBox(-1.4F, 4.0F, -3.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.4F, 7.0F, -6.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition legright = legcore.addOrReplaceChild("legright", CubeListBuilder.create().texOffs(25, 63).mirror().addBox(-3.6F, -2.0F, -5.0F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(51, 67).mirror().addBox(-2.6F, 4.0F, -3.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(-3.6F, 7.0F, -6.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(CaimanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationDefinitions.CAIMAN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.CAIMAN_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		caiman.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return caiman;
	}
}