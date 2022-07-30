package com.ND0322.trufflemod.capability.maxHealth;

import com.ND0322.trufflemod.truffleMod;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class MaxHealth implements IMaxHealth {
	public static final ResourceLocation ID = new ResourceLocation(truffleMod.MOD_ID, "max_health");
	
	
	
    
	private float maxHealthChanger;
	
	public MaxHealth() {maxHealthChanger = 200;}
    public MaxHealth(int maxHealthChanger) { this.maxHealthChanger = maxHealthChanger; }
	
    public void saveNBTData(CompoundTag compound) {
        compound.putFloat("bonusHealth", maxHealthChanger);
    }

    public void loadNBTData(CompoundTag compound) {
        maxHealthChanger = compound.getFloat("bonusHealth");
    }
    
    public void copyFrom(MaxHealth source) {
        maxHealthChanger = source.maxHealthChanger;
    }

	@Override
	public float getMaxHealth() {
		
		return maxHealthChanger;
	}

	@Override
	public void setMaxHealth(float value) {
		maxHealthChanger = value;

	}
	
	public void addMaxHealth(float value) {
		
		maxHealthChanger += value;
	}
	public void subtractMaxHealth(float value) {
		maxHealthChanger -= value;
	}

}
