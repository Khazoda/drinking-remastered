package com.seacroak.drinking_remastered.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.seacroak.drinking_remastered.SoundRegistry;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.component.LiteralComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

@Mixin(PotionItem.class)
public class PotionMixin {
    private static Random rand = new Random();

    private static final SoundEvent sounds[] = { SoundRegistry.CUPCAKKE, SoundRegistry.SIP_1 };

    @Inject(method = "getUseAction", at = @At("HEAD"), cancellable = true)
    protected void getUseAction(CallbackInfoReturnable<UseAction> ci) {
        ci.setReturnValue(UseAction.DRINK);

    }

    @Inject(method = "use", at = @At("HEAD"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    protected void onUse(World world, PlayerEntity user, Hand hand,
            CallbackInfoReturnable<TypedActionResult<ItemStack>> ci) {

        if (world.getServer() == null) {
            user.sendMessage(MutableText.create(new LiteralComponent(String.valueOf(rand.nextInt(sounds.length)))),
                    false);
        }
        user.setHealth(user.getHealth() - 1);
        world.playSound(user, user.getX(), user.getY(), user.getZ(), sounds[rand.nextInt(sounds.length)],
                SoundCategory.NEUTRAL,
                1f, 1f);

    }
}
