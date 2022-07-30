package com.ND0322.trufflemod.effects;

import com.ND0322.trufflemod.truffleMod;

import net.minecraft.world.effect.AttackDamageMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = 
	DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,truffleMod.MOD_ID);
	
	
		
		
	public static final RegistryObject<MobEffect> DAMAGE_BOOST_EFFECT = MOB_EFFECTS.register("copperized",
            () -> new DamageBoostEffect(MobEffectCategory.BENEFICIAL, 3124687).addAttributeModifier(Attributes.ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 1d, AttributeModifier.Operation.ADDITION));
	
	public static void register(IEventBus eventBus) {
		MOB_EFFECTS.register(eventBus);

	}
}
