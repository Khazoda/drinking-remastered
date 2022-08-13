package com.seacroak.drinking_remastered;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class SoundRegistry {
	public static final SoundEvent SILENCE = register("silence");

	public static final SoundEvent SIP_1 = register("sip_1");
	public static final SoundEvent CUPCAKKE = register("cupcakke");

	public static void init() {
	}

	private static SoundEvent register(String name) {
		return Registry.register(Registry.SOUND_EVENT, name, new SoundEvent(new Identifier(Drinking.MOD_ID, name)));
	}

}