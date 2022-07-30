package com.ND0322.trufflemod.common.container;

import com.ND0322.trufflemod.init.ContainerInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BagContaoner extends AbstractContainerMenu{
	 

	 
	 public BagContaoner(int id, Inventory playerInv) {
	        this(id, playerInv, new ItemStackHandler(27), BlockPos.ZERO);
	    }
	 
	 public BagContaoner(int id, Inventory playerInv, IItemHandler slots, BlockPos pos) {
	        super(ContainerInit.BAG_CONTAINER.get(), id);
	 }
	@Override
	public boolean stillValid(Player p) {
		// TODO Auto-generated method stub
		return false;
	}
}
