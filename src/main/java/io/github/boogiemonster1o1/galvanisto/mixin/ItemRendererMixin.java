package io.github.boogiemonster1o1.galvanisto.mixin;

import io.github.boogiemonster1o1.galvanisto.block.GalvanistoOreBlock;
import io.github.boogiemonster1o1.galvanisto.block.ModBlocks;
import io.github.boogiemonster1o1.galvanisto.block.OreVariant;
import io.github.boogiemonster1o1.galvanisto.item.ModItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.ModelIdentifier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@Shadow protected abstract void method_3964(Block arg, int i, String string);

	@Shadow @Final private ItemModels field_4876;

	@Inject(method = "method_3986", at = @At("HEAD"))
	public void registerModels(CallbackInfo ci) {
//		this.field_4876.method_3497(ModItems.oreItem(), OreVariant.COPPER.ordinal(), new ModelIdentifier("galvanisto:copper_ore", "normal"));
//		this.field_4876.method_3497(ModItems.oreItem(), OreVariant.SILVER.ordinal(), new ModelIdentifier("galvanisto:silver_ore", "normal"));
//		this.field_4876.method_3497(ModItems.oreItem(), OreVariant.ALUMINIUM.ordinal(), new ModelIdentifier("galvanisto:aluminium_ore", "normal"));
//		this.method_3964(, OreVariant.COPPER.ordinal(), "galvanisto:copper_ore");
//		this.method_3964(GalvanistoOreBlock.instance(), OreVariant.SILVER.ordinal(), "galvanisto:silver_ore");
//		this.method_3964(GalvanistoOreBlock.instance(), OreVariant.ALUMINIUM.ordinal(), "galvanisto:aluminium_ore");
	}
}
