package com.ND0322.trufflemod.client.event;

import java.util.Random;
import java.util.UUID;

import com.ND0322.trufflemod.client.screen.CharmsBagScreen;
import com.ND0322.trufflemod.init.ContainerInit;
import com.mojang.blaze3d.platform.ScreenManager;

import data.trufflemod.attributes.modAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
	
	@SubscribeEvent
	public static void onEntityAttributeModificationEvent(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, modAttributes.CRIT_CHANCE.get());
		event.add(EntityType.PLAYER, modAttributes.CRIT_DAMAGE.get());
		event.add(EntityType.PLAYER, modAttributes.DEFENSE.get());
		event.add(EntityType.PLAYER, modAttributes.MELEE_DAMAGE.get());
		event.add(EntityType.PLAYER, modAttributes.MAGIC_DAMAGE.get());
		event.add(EntityType.PLAYER, modAttributes.RANGED_DAMAGE.get());
		event.add(EntityType.PLAYER, modAttributes.THROWING_DAMAGE.get());
		event.add(EntityType.PLAYER, modAttributes.PLAYER_HEALTH.get());
		event.add(EntityType.PLAYER, modAttributes.DAMAGE_MULTIPLIER.get());
		event.add(EntityType.PLAYER, modAttributes.DAMAGE_REDUCTION.get());
		
		
		
		
	}
	
	
	
	@SubscribeEvent
	public static void onAttack(AttackEntityEvent event) {
		
		Player player = event.getPlayer();
		
		
		
		AttributeModifier MELEE_DAMAGE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d41"), "melee_damage", player.getAttributeValue(modAttributes.MELEE_DAMAGE.get()), AttributeModifier.Operation.ADDITION);
		AttributeModifier MELEE_MULTIPLIER = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d42"), "damage modifier", player.getAttributeValue(modAttributes.DAMAGE_MULTIPLIER.get()), AttributeModifier.Operation.MULTIPLY_TOTAL);
		AttributeModifier CRIT_DAMAGE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d43"), "crit_damage", player.getAttributeValue(modAttributes.CRIT_DAMAGE.get()), AttributeModifier.Operation.MULTIPLY_BASE);
		
		
		
		player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(MELEE_DAMAGE);
		player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(MELEE_DAMAGE);
		
		player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(MELEE_MULTIPLIER);
		player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(MELEE_MULTIPLIER);
		
		Random rand = new Random();
		
		float float_random = (float)rand.nextInt(101);
		
		if(float_random <= player.getAttributeValue(modAttributes.CRIT_CHANCE.get())) {
			player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(CRIT_DAMAGE);
			player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(CRIT_DAMAGE);
		}
		
		
		 System.out.println("before change" + player.getAttributeValue(Attributes.ATTACK_DAMAGE));
		
		
	}
	
	@SubscribeEvent
	public static void onCriticalHit(CriticalHitEvent event) {
		event.setResult(Result.DENY);
	}
	
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		
		
        MenuScreens.register(ContainerInit.CHARM_CONTAINER.get(), CharmsBagScreen::new);
    }
	
	
}
