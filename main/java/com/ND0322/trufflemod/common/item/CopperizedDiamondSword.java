package com.ND0322.trufflemod.common.item;

import java.util.UUID;

import com.ND0322.trufflemod.effects.ModEffects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import data.trufflemod.attributes.modAttributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;




public class CopperizedDiamondSword extends SwordItem{
	

	
	public CopperizedDiamondSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
	
		
	}
	
	
	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
				AttributeModifier MELEE_DAMAGE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d41"), "melee_damage", 6f, AttributeModifier.Operation.ADDITION);
				AttributeModifier CRIT_DAMAGE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d54"), "crit_damage", 0.1f, AttributeModifier.Operation.ADDITION);
				AttributeModifier CRIT_CHANCE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651f65"), "crit_chance", 4f, AttributeModifier.Operation.ADDITION);
		if(stack.getItem() instanceof CopperizedDiamondSword && isSelected) {
			if(entityIn instanceof Player) {
			
				
				
				((Player) entityIn).getAttribute(modAttributes.CRIT_DAMAGE.get()).removeModifier(CRIT_DAMAGE);
				((Player) entityIn).getAttribute(modAttributes.CRIT_DAMAGE.get()).addTransientModifier(CRIT_DAMAGE);
				
				((Player) entityIn).getAttribute(modAttributes.CRIT_CHANCE.get()).removeModifier(CRIT_CHANCE);
				((Player) entityIn).getAttribute(modAttributes.CRIT_CHANCE.get()).addTransientModifier(CRIT_CHANCE);
				
				((Player) entityIn).getAttribute(modAttributes.MELEE_DAMAGE.get()).removeModifier(MELEE_DAMAGE);
				((Player) entityIn).getAttribute(modAttributes.MELEE_DAMAGE.get()).addTransientModifier(MELEE_DAMAGE);
				
				
				}
			}
		if(stack.getItem() instanceof CopperizedDiamondSword && !isSelected) {
			((Player) entityIn).getAttribute(modAttributes.CRIT_DAMAGE.get()).removeModifier(CRIT_DAMAGE);
			((Player) entityIn).getAttribute(modAttributes.CRIT_CHANCE.get()).removeModifier(CRIT_CHANCE);
			((Player) entityIn).getAttribute(modAttributes.MELEE_DAMAGE.get()).removeModifier(MELEE_DAMAGE);
			
		}
	}	
	
	

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		
		MobEffectInstance m = new MobEffectInstance(ModEffects.DAMAGE_BOOST_EFFECT.get(),200,1);
		player.addEffect(m);
		
		player.getCooldowns().addCooldown(this,600);
		
		
			
	
	
		return super.use(world,player,hand);
	}
}
