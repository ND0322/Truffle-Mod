package com.ND0322.trufflemod.client.event;

import java.util.UUID;

import com.ND0322.trufflemod.capability.maxHealth.IMaxHealth;
import com.ND0322.trufflemod.capability.maxHealth.MaxHealth;
import com.ND0322.trufflemod.capability.maxHealth.MaxHealthProvider;

import data.trufflemod.attributes.modAttributes;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderNameplateEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;







@Mod.EventBusSubscriber
public class PlayerEventHandler {
	
	
	
	@SubscribeEvent
	public static void onEvent(EntityJoinWorldEvent event) {
	      if ((event.getEntity() instanceof Player)) {
	    	  Player player = (Player)event.getEntity();
	    	  
	    	  
	    	  
	    	 
	    	 
	    	  AttributeModifier HEALTH_BOOST = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d40"), "max_health", player.getAttributeValue(modAttributes.PLAYER_HEALTH.get()), AttributeModifier.Operation.ADDITION);
	    	  AttributeModifier NO_DEFENSE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987654f67"), "max_health", -1, AttributeModifier.Operation.MULTIPLY_TOTAL);
	  		  AttributeModifier NO_TOUGHNESS = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d59"), "max_health", -1, AttributeModifier.Operation.MULTIPLY_TOTAL);
				
	  		
	  		
	  		   player.getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BOOST);
	  		   player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(HEALTH_BOOST);
	  		   
	  		   player.getAttribute(modAttributes.CRIT_DAMAGE.get()).setBaseValue(.5);
	  		   player.getAttribute(modAttributes.CRIT_CHANCE.get()).setBaseValue(4);
	  		  
	  		  
	  		   
				
	  		   player.getAttribute(modAttributes.DEFENSE.get()).addTransientModifier(new AttributeModifier(UUID.randomUUID(), "max_health", player.getAttributeValue(Attributes.ARMOR), AttributeModifier.Operation.MULTIPLY_TOTAL));
	  		   player.getAttribute(Attributes.ARMOR).addTransientModifier(NO_DEFENSE);
	  		   player.getAttribute(Attributes.ARMOR_TOUGHNESS).addTransientModifier(NO_TOUGHNESS);
	  		
	  		
	    	  
	      }
	      else if(event.getEntity() instanceof LivingEntity && !(event.getEntity() instanceof Player) ) {
	    	AttributeModifier CHANGE_HEALTH = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987354f67"), "max_health", 1.5, AttributeModifier.Operation.MULTIPLY_BASE);
	    	AttributeModifier CHANGE_DAMAGE = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987374f67"), "max_health", 2.5, AttributeModifier.Operation.MULTIPLY_BASE);
	  		
	    
	  		
	  		
	  		event.getEntity().setCustomName(event.getEntity().getDisplayName());
	    	event.getEntity().setCustomNameVisible(true);
	    	
	    	LivingEntity e = (LivingEntity)event.getEntity();
	    	e.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(CHANGE_HEALTH);
	    	e.heal(Integer.MAX_VALUE);
	    	
	    	if(e.getAttribute(Attributes.ATTACK_DAMAGE) != null) {
	    		e.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(CHANGE_DAMAGE);
	    	}
	    	
	       
	    	 
	      }
	      
	      
	    	
	      
	  }
	
	
	public static void onPlayerLoggedOut(PlayerLoggedOutEvent event) {
		Player player = event.getPlayer();
		player.getCapability(MaxHealthProvider.MAX_HEALTH_CHANGER).ifPresent(MaxHealth -> {
             MaxHealth.setMaxHealth(player.getHealth());
          });
		
	}
	
	public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		Player player = event.getPlayer();
		
		LazyOptional<MaxHealth> data = player.getCapability(MaxHealthProvider.MAX_HEALTH_CHANGER);
        data.ifPresent((test) -> {
           player.heal(test.getMaxHealth());
        });
		
			
			
		
		
	}
	
	@SubscribeEvent
	public static void respawnPlayer(PlayerEvent.PlayerRespawnEvent event) {
		
	  Player player = event.getPlayer();
	  
 	 
	  
	 
	  AttributeModifier HEALTH_BOOST = new AttributeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d40"), "max_health", player.getAttributeValue(modAttributes.PLAYER_HEALTH.get()), AttributeModifier.Operation.ADDITION);
	  
	 
	  
	  
	  
		  
	   
		
		
		
	  player.getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_BOOST);
	  player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(HEALTH_BOOST);
	
		
	 
	
	}
	
	
	public static void playerTick(PlayerTickEvent event) {
		
		
		if(event.player.getAttribute(Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d41")) != null){
			event.player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d41"));
		}
		if(event.player.getAttribute(Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d42")) != null){
			event.player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d42"));
		}
		if(event.player.getAttribute(Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d43")) != null){
			event.player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("fb84a4dd-8592-48f7-8e47-911987651d43"));
		}
		
		 
	}
	

	
	
	public static void createHealthBar(RenderNameplateEvent event) {
		
		
		if (event.getEntity() instanceof LivingEntity) {
			
			LivingEntity e = (LivingEntity)event.getEntity();
			Player player = Minecraft.getInstance().player;
			
			Vec3 view = player.getEyePosition();
			
			
			Vec3 ePos = e.position();
			String currentHealth = (Integer.toString((int)e.getHealth()));
	    	String maxHealth = (Integer.toString((int)e.getMaxHealth()));
			
				
	    	MutableComponent r = new TextComponent(" " + "♥" + " "  + currentHealth + "/" + maxHealth).withStyle(ChatFormatting.RED);
	    	
	    	if(event.getEntity().getDisplayName() == new TextComponent("Placeholder")) {MutableComponent s = new TextComponent("Villager");
	    		event.setContent(s.append(r));
	    	}
	    	if(event.getEntity() instanceof IronGolem) {MutableComponent s = new TextComponent("Iron Golem");
	    		event.setContent(s.append(r));
	    	}
	    
	    	else{MutableComponent s = (MutableComponent) event.getEntity().getDisplayName();
	    		event.setContent(s.append(r));
	    	}
	    	
	    	
	    	e.setCustomNameVisible(false);
	    	
			if (view == ePos || e.getHealth() < e.getMaxHealth()) {
				e.setCustomNameVisible(true);
		    	  
		    	
		    	  
		    	  
			}
			
					
			
		
			
		}
		
	    
	    
	}
	
	@SubscribeEvent
	public static void onLivingHurt(LivingHurtEvent event) {
		
		if(event.getEntityLiving() instanceof Player) {
			
				Float equation = (float) (event.getAmount() - (.25 * event.getEntityLiving().getAttributeValue(modAttributes.DEFENSE.get())));
				equation = (float) (equation - equation * (event.getEntityLiving().getAttributeValue(modAttributes.DAMAGE_REDUCTION.get()) / 100));
				System.out.println(equation);
			
				if (equation <= 0) {
					event.setAmount(1);
				}
				else {
					event.setAmount(equation);
				
				}
			
			
			
			
		}
		
	}
	
	
	
	
	
	
    
	
	
	
		
	
	 
}
