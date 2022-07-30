package com.ND0322.trufflemod.capability.charmBag;

import com.ND0322.trufflemod.truffleMod;
import com.ND0322.trufflemod.capability.maxHealth.MaxHealth;
import com.ND0322.trufflemod.capability.maxHealth.MaxHealthProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CharmBagEventHandler {
	@SubscribeEvent
	
	
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
		
		
        if (event.getObject() instanceof Player) {
        	
        	 if (!event.getObject().getCapability(CharmBagProvider.Handler).isPresent()) {
        	
                event.addCapability(new ResourceLocation(truffleMod.MOD_ID, "charm_bag_cap"), new CharmBagProvider());
                
            }
        }
    }
	
	
	@SubscribeEvent
	public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            // We need to copyFrom the capabilities
            event.getOriginal().getCapability(CharmBagProvider.Handler).ifPresent(oldStore -> {
                event.getPlayer().getCapability(CharmBagProvider.Handler).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }
    
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(CharmBagItemStackHandler.class);
    }
}
