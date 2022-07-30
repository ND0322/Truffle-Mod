package com.ND0322.trufflemod.capability.maxHealth;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.checkerframework.checker.nullness.qual.NonNull;

import com.ND0322.trufflemod.truffleMod;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MaxHealthProvider implements ICapabilityProvider,INBTSerializable<CompoundTag> {
	public static Capability<MaxHealth> MAX_HEALTH_CHANGER = CapabilityManager.get(new CapabilityToken<>(){});

    private MaxHealth maxHealth = null;
    private final LazyOptional<MaxHealth> opt = LazyOptional.of(this::createMaxHealth);

    @Nonnull
    private MaxHealth createMaxHealth() {
        if (maxHealth == null) {
            maxHealth = new MaxHealth();
        }
        return maxHealth;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == MAX_HEALTH_CHANGER) {
            return opt.cast();
        }
        return LazyOptional.empty();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createMaxHealth().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createMaxHealth().loadNBTData(nbt);
    }
}
