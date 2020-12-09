package io.github.boogiemonster1o1.galvanisto.mixin;

import io.github.boogiemonster1o1.galvanisto.block.GalvanistoOreBlock;
import io.github.boogiemonster1o1.galvanisto.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.ItemStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
	@ModifyVariable(method = "method_3982", at = @At("HEAD"))
	public BakedModel modifyModel(BakedModel bakedModel, ItemStack itemStack, BakedModel ignored) {
		if (itemStack.getItem() == ModItems.oreItem()) {
			return ((BlockRenderManagerAccessor) MinecraftClient.getInstance().getBlockRenderManager()).callMethod_3592(GalvanistoOreBlock.stateFromData(itemStack.getMeta()), null);
		}
		return bakedModel;
	}
}
