package com.ND0322.trufflemod.common.item;

import javax.annotation.Nullable;

import com.ND0322.trufflemod.common.container.CharmsBagContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class CharmsBag extends Item implements MenuProvider{
	 
	 
	public CharmsBag(Properties properties) {
		super(properties);
		
	}
	
	 @Override
	    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand hand) {
	        if(!pLevel.isClientSide()){
	            if(hand == InteractionHand.MAIN_HAND){
	                NetworkHooks.openGui(((ServerPlayer) pPlayer),this);
	            }
	        }
	        return InteractionResultHolder.success(pPlayer.getItemInHand(hand));
	    }
	 
	 @Override
	 public Component getDisplayName() {
	        return new TextComponent("Charm Bag");
	    }

	 @Nullable
	 @Override
	 public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
	        return new CharmsBagContainer(pContainerId, pInventory, pPlayer.getMainHandItem());
	    }

}
