package com.ND0322.trufflemod.capability.charmBag;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CharmBagProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>{
	public static Capability<CharmBagItemStackHandler> Handler = CapabilityManager.get(new CapabilityToken<>(){});
	
	private CharmBagItemStackHandler inventory = new CharmBagItemStackHandler(9);
	private Player player;
	
	private LazyOptional<CharmBagItemStackHandler> lazyOptional = LazyOptional.of(() -> inventory);
	
	

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		
		
		if (cap == Handler) {
	            lazyOptional.cast();
	        }
	        return LazyOptional.empty();
	      
	}

	@Override
	public CompoundTag serializeNBT() {
		return inventory.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		inventory.deserializeNBT(nbt);
		
	}

	


}
