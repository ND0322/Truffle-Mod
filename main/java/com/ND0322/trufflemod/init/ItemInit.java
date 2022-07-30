package com.ND0322.trufflemod.init;

import com.ND0322.trufflemod.truffleMod;
import com.ND0322.trufflemod.common.item.CharmsBag;
import com.ND0322.trufflemod.common.item.CopperizedDiamondSword;
import com.google.common.base.Supplier;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, truffleMod.MOD_ID);
	
	//Dogecoins
	public static final RegistryObject<Item> BRONZE_DOGE_COIN = register("bronze_doge_coin", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> SILVER_DOGE_COIN = register("silver_doge_coin", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> GOLD_DOGE_COIN = register("gold_doge_coin", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> DIAMOND_DOGE_COIN = register("diamond_doge_coin", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	//Weapons
	public static final RegistryObject<Item> COPPERIZED_DIAMOND_SWORD = register("copperized_diamond_sword", () -> new CopperizedDiamondSword(ToolMaterialInit.Copperized_Diamond,0,-1.6f,new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> LASER_STORM_BOW = register("laser_storm_bow", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	//Gear
	//public static final RegistryObject<Item> COPPERIZED_DIAMOND_HELMET = register("copperized_diamond_helmet", () -> new ArmorItem(ArmorMaterialInit.Copperized_Diamond,));
	
	//Charm Bags
		
	public static final RegistryObject<Item> LARGE_CHARM_BAG = register("large_charm_bag", () -> new CharmsBag(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	
	
	//Charm Bases
	public static final RegistryObject<Item> COMMON_CHARM_BASE = register("common_charm_base", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> UNCOMMON_CHARM_BASE = register("uncommon_charm_base", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> RARE_CHARM_BASE = register("rare_charm_base", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> EPIC_CHARM_BASE = register("epic_charm_base", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> LEGENDARY_CHARM_BASE = register("legendary_charm_base", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	public static final RegistryObject<Item> DIVINE_CHARM_BASE = register("divine_charm_base", () -> new Item(new Item.Properties().tab(truffleMod.Truffle_Tab)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		
		return ITEMS.register(name, item);
	}
	
}
