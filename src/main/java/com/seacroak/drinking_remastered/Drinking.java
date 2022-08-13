package com.seacroak.drinking_remastered;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Drinking implements ModInitializer {
	public static final String MOD_ID = "drinking_remastered";
	public static final Logger LOGGER = LoggerFactory.getLogger("Drinking Remastered");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("It's Drinking Time.");
		SoundRegistry.init();

	}
}
