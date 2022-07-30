package com.ND0322.trufflemod.init;

import com.ND0322.trufflemod.init.ItemInit;
import com.ND0322.trufflemod.util.BaseToolMaterial;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public final class ToolMaterialInit {
	private ToolMaterialInit() {}
	
	protected static final Tier Copperized_Diamond = new BaseToolMaterial(0f, 500, 5, 5f, 2500,() -> Ingredient.of(Items.DIAMOND));
		
	
}
