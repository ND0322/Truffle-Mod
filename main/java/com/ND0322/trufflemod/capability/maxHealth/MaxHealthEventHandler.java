package com.ND0322.trufflemod.capability.maxHealth;

import com.ND0322.trufflemod.truffleMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MaxHealthEventHandler {
	@SubscribeEvent
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(MaxHealthProvider.MAX_HEALTH_CHANGER).isPresent()) {
                // The player does not already have this capability so we need to add the capability provider here
                event.addCapability(new ResourceLocation(truffleMod.MOD_ID, "max_health"), new MaxHealthProvider());
            }
        }
    }
	@SubscribeEvent
	public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            // We need to copyFrom the capabilities
            event.getOriginal().getCapability(MaxHealthProvider.MAX_HEALTH_CHANGER).ifPresent(oldStore -> {
                event.getPlayer().getCapability(MaxHealthProvider.MAX_HEALTH_CHANGER).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }
    
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(MaxHealth.class);
    }
}
