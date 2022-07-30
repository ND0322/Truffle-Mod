package data.trufflemod.attributes;

import java.util.UUID;

import com.ND0322.trufflemod.truffleMod;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, truffleMod.MOD_ID);
	
	//ATTRIBUTES
	public static final RegistryObject<Attribute> CRIT_CHANCE = ATTRIBUTES.register("crit_chance", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerCritChance", 4, 0, 1000).setSyncable(true));
	public static final RegistryObject<Attribute> CRIT_DAMAGE = ATTRIBUTES.register("crit_damage", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerCritDamage", .5, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> DEFENSE = ATTRIBUTES.register("defense", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerDefense", 0, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> MELEE_DAMAGE = ATTRIBUTES.register("melee_damage", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerMeleeDamage", 0, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> RANGED_DAMAGE = ATTRIBUTES.register("ranged_damage", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerRangedDamage", 0, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> THROWING_DAMAGE = ATTRIBUTES.register("throwing_damage", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerThrowingDamage", 0, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> MAGIC_DAMAGE = ATTRIBUTES.register("magic_damage", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerMagicDamage", 0, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> DAMAGE_MULTIPLIER = ATTRIBUTES.register("damage_multiplier", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerDamageMultiplier", 0, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> PLAYER_HEALTH = ATTRIBUTES.register("player_health", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerHealth", 100, 0, Float.MAX_VALUE).setSyncable(true));
	public static final RegistryObject<Attribute> DAMAGE_REDUCTION = ATTRIBUTES.register("damage_reduction", () -> (Attribute) new RangedAttribute(truffleMod.MOD_ID + ".playerDamageReduction", 0, 0, Float.MAX_VALUE).setSyncable(true));
	
}
