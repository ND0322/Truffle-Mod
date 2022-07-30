package com.ND0322.trufflemod.init;

import com.ND0322.trufflemod.truffleMod;
import com.ND0322.trufflemod.common.container.BagContaoner;
import com.ND0322.trufflemod.common.container.CharmsBagContainer;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ContainerInit {
	
	
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,truffleMod.MOD_ID);
	
	
	public static final RegistryObject<MenuType<CharmsBagContainer>> CHARM_CONTAINER = CONTAINERS.register("charms_bag", () -> new MenuType<>(CharmsBagContainer::new));
	

	public static final RegistryObject<MenuType<BagContaoner>> BAG_CONTAINER = CONTAINERS.register("bag", () -> new MenuType<>(BagContaoner::new));
	
	private ContainerInit() {
		 
	}
}
