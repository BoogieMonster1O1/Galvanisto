package io.github.boogiemonster1o1.galvanisto.mixin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.github.boogiemonster1o1.galvanisto.item.GalvanistoIngotItem;
import io.github.boogiemonster1o1.galvanisto.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.item.Item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(ModelLoader.class)
public class ModelLoaderMixin {
	@Shadow private Map<Item, List<String>> field_5373;

	@Inject(method = "method_4483", at = @At("TAIL"))
	public void registerBlockItemVariantStuff(CallbackInfo ci) {
		this.field_5373.put(ModItems.oreItem(), Arrays.asList("galvanisto:copper_ore", "galvanisto:silver_ore", "galvanisto:aluminium_ore"));
		this.field_5373.put(GalvanistoIngotItem.instance(), Arrays.asList("galvanisto:copper_ingot", "galvanisto:silver_ingot", "galvanisto:aluminium_ingot"));
	}
}
