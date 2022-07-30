package com.ND0322.trufflemod.client.screen;

import com.ND0322.trufflemod.truffleMod;
import com.ND0322.trufflemod.common.container.CharmsBagContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CharmsBagScreen extends AbstractContainerScreen<CharmsBagContainer>{
	private static final ResourceLocation TEXTURE = new ResourceLocation(truffleMod.MOD_ID,"textures/gui/charm_bag_gui.png");
	public CharmsBagScreen(CharmsBagContainer container, Inventory playerInv, Component title) {
		super(container, playerInv, new TextComponent("Charm Bag"));
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 156;
		this.imageHeight = 166;
		
	}

	@Override
	protected void renderBg(PoseStack stack, float mouseX, int mouseY, int partialTicks) {
		// TODO Auto-generated method stub
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1);
		RenderSystem.setShaderTexture(0, TEXTURE);
		blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
		
		
	}
	
	@Override
    protected void init() {
        super.init();
        
    }
	
	@Override
	protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
		drawString(stack, this.font, this.title, this.leftPos + 8, this.topPos + 3, 0x404040);
		drawString(stack, this.font, playerInventoryTitle, this.leftPos + 8, this.topPos + 80, 0x404040);
	}

}
