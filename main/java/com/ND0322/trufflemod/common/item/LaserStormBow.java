package com.ND0322.trufflemod.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LaserStormBow extends Item {
	public int charges;
	
	public LaserStormBow(Properties properties, int charges) {
		super(properties);
		this.charges = charges;
	}
	
	public int getCharges() {
		return charges;
	}
	
	public void setCharges(int amount) {
		charges = amount;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		if (this.charges > 0) {
			
			
		}
		
		
		return super.use(world,player,hand);	
		
			
		}
	

}
