package com.seacroak.drinking_remastered.mixin;

import org.apache.logging.log4j.core.config.builder.api.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.MixinEnvironment.Side;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.brigadier.LiteralMessage;
import com.seacroak.drinking_remastered.Drinking;
import com.seacroak.drinking_remastered.SoundRegistry;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.component.LiteralComponent;
import net.minecraft.text.component.TranslatableComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

@Mixin(Item.class)
public class DrinkMixin {

    @Inject(method = "getDrinkSound", at = @At("HEAD"), cancellable = true)
    protected void getDrinkSound(CallbackInfoReturnable<SoundEvent> ci) {
        ci.setReturnValue(SoundRegistry.SILENCE);

    }

}
