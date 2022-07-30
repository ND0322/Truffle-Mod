package com.ND0322.trufflemod;

import com.ND0322.trufflemod.capability.charmBag.CharmBagEventHandler;
import com.ND0322.trufflemod.capability.maxHealth.IMaxHealth;
import com.ND0322.trufflemod.capability.maxHealth.MaxHealthEventHandler;
import com.ND0322.trufflemod.client.event.EventHandler;
import com.ND0322.trufflemod.client.event.PlayerEventHandler;
import com.ND0322.trufflemod.client.screen.CharmsBagScreen;
import com.ND0322.trufflemod.effects.ModEffects;
import com.ND0322.trufflemod.init.ContainerInit;
import com.ND0322.trufflemod.init.ItemInit;

import data.trufflemod.attributes.modAttributes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



@Mod("trufflemod")
public class truffleMod {
	public static final String MOD_ID = "trufflemod";
	
	public static final CreativeModeTab Truffle_Tab = new CreativeModeTab(MOD_ID) { 
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.BRONZE_DOGE_COIN.get());
			
		}
	};
	
	
	public truffleMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus eventBus = MinecraftForge.EVENT_BUS;
		
		
	
		
		ItemInit.ITEMS.register(bus);
		ModEffects.register(bus);
		modAttributes.ATTRIBUTES.register(bus);
		ContainerInit.CONTAINERS.register(bus);
		MinecraftForge.EVENT_BUS.register(this);
		
		eventBus.addGenericListener(Entity.class, MaxHealthEventHandler::onAttachCapabilitiesPlayer);
        eventBus.addListener(MaxHealthEventHandler::onPlayerCloned);
        eventBus.addListener(MaxHealthEventHandler::onRegisterCapabilities);
        eventBus.addGenericListener(Entity.class, CharmBagEventHandler::onAttachCapabilitiesPlayer);
        eventBus.addListener(CharmBagEventHandler::onPlayerCloned);
        eventBus.addListener(CharmBagEventHandler::onRegisterCapabilities);
        
       
        bus.addListener(EventHandler::onEntityAttributeModificationEvent);
        eventBus.addListener(PlayerEventHandler::onPlayerLoggedIn);
        eventBus.addListener(PlayerEventHandler::onPlayerLoggedOut);
        eventBus.addListener(EventHandler::onAttack);
        eventBus.addListener(EventHandler::onCriticalHit);
        eventBus.addListener(PlayerEventHandler::playerTick);
        eventBus.addListener(PlayerEventHandler::createHealthBar);
        bus.addListener(EventHandler::clientSetup);
	}
	
	

	
}


