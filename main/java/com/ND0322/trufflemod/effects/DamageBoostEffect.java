package com.ND0322.trufflemod.effects;

import com.ND0322.trufflemod.common.item.CopperizedDiamondSword;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class DamageBoostEffect extends MobEffect {
    public DamageBoostEffect(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory, color);
           
    }
    
    
  
    
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    } 
}
