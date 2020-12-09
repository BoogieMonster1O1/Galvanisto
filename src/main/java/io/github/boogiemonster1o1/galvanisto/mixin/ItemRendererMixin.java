package io.github.boogiemonster1o1.galvanisto.mixin;

import io.github.boogiemonster1o1.galvanisto.block.GalvanistoOreBlock;
import io.github.boogiemonster1o1.galvanisto.block.OreVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.client.render.item.ItemRenderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@Shadow protected abstract void method_3964(Block arg, int i, String string);

	@Inject(method = "method_3986", at = @At("HEAD"))
	public void registerModels(CallbackInfo ci) {
		this.method_3964(GalvanistoOreBlock.instance(), OreVariant.COPPER.ordinal(), "copper_ore");
		this.method_3964(GalvanistoOreBlock.instance(), OreVariant.SILVER.ordinal(), "silver_ore");
		this.method_3964(GalvanistoOreBlock.instance(), OreVariant.ALUMINIUM.ordinal(), "aluminium_ore");
	}
}
