package com.ND0322.trufflemod.common.container;

import com.ND0322.trufflemod.capability.charmBag.CharmBagProvider;
import com.ND0322.trufflemod.common.item.CharmsBag;
import com.ND0322.trufflemod.init.ContainerInit;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;




public class CharmsBagContainer extends AbstractContainerMenu{
	private final ItemStack charmBag;
    private final Level level;
    
    
    
    // Client Constructor
    public CharmsBagContainer(int id, Inventory playerInv) {
    	this(id, playerInv, playerInv.player.getMainHandItem());
    }

    // Server constructor
    public CharmsBagContainer(int id, Inventory inventory, ItemStack item) {
        super(ContainerInit.CHARM_CONTAINER.get(), id);
       
        this.level = inventory.player.level;
        this.charmBag = item;
        Player player = inventory.player;     
      
        
        
       System.out.println(player.getCapability(CharmBagProvider.Handler).isPresent());
       player.getCapability(CharmBagProvider.Handler).ifPresent(handler -> {
            for(int i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    this.addSlot(new SlotItemHandler(handler, j + i * 3, 44 + j * 18, 16 + i * 18));
                }
            }
        });
     
        

      
        
        this.addPlayerHotbar(inventory);
        this.addPlayerInventory(inventory);
      
        
        
    }
    
    private void addPlayerInventory(Inventory inv){
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }
    

    private void addPlayerHotbar(Inventory inv){
        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
        }
    }

   
    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack toReturn = ItemStack.EMPTY;
        Slot slot = this.getSlot(pIndex);
        if(slot != null && slot.hasItem()){
            ItemStack stack = slot.getItem();
            toReturn = stack.copy();
            if(pIndex < 9){
                if(!this.moveItemStackTo(stack, 9, this.slots.size(), true)){
                    return ItemStack.EMPTY;
                }
            }else if(!this.moveItemStackTo(stack, 0, 9, false)){
                return ItemStack.EMPTY;
            }

            if(!stack.isEmpty()){
                slot.set(ItemStack.EMPTY);
            }else{
                slot.setChanged();
            }
        }
        return toReturn;
    }
   
	@Override
	public boolean stillValid(Player player) {
		
		return player.getMainHandItem().is(this.charmBag.getItem());
	}

   
    
   
	
}