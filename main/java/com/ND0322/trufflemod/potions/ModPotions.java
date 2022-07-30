package com.ND0322.trufflemod.potions;

import com.ND0322.trufflemod.truffleMod;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions {
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS,truffleMod.MOD_ID);
	
	
	public static void register(IEventBus eventBus) {
		POTIONS.register(eventBus);
		
	}
}
