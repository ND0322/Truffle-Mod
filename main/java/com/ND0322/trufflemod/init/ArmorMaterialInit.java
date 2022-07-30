package com.ND0322.trufflemod.init;

import com.ND0322.trufflemod.util.BaseArmorMaterial;
import com.ND0322.trufflemod.util.BaseToolMaterial;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit {
	private ArmorMaterialInit() {}
	
	protected static final ArmorMaterial Copperized_Diamond = new BaseArmorMaterial(100, new int[] {950,1400,2000,1000},new int[] {20,35,50,30}
	,3.2f, 1.85f,"Copperized Diamond", SoundEvents.BEEHIVE_ENTER,() -> Ingredient.of(Items.DIAMOND));
}