package com.ND0322.trufflemod.capability.charmBag;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class CharmBagItemStackHandler extends ItemStackHandler implements CharmBagItemHandler {
	public int size;
	public CharmBagItemStackHandler(int size) {
		super(size);
	}
	
	public CharmBagItemStackHandler() {
		super(9);
	}

	public void copyFrom(CharmBagItemStackHandler source) {
		this.size = source.size;
		
	}
	
	

}
