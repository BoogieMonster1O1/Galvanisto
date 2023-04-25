package io.github.boogiemonster1o1.galvanisto.mixin;

import io.github.boogiemonster1o1.galvanisto.block.GalvanistoOreBlock;
import io.github.boogiemonster1o1.galvanisto.block.OreVariant;
import io.github.boogiemonster1o1.galvanisto.item.GalvanistoIngotItem;
import io.github.boogiemonster1o1.galvanisto.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@Shadow protected abstract void method_3977(Item item, int i, String string);

	@ModifyVariable(method = "method_3982", at = @At("HEAD"))
	public BakedModel modifyModel(BakedModel bakedModel, ItemStack itemStack, BakedModel ignored) {
		if (itemStack.getItem() == ModItems.oreItem()) {
			return ((BlockRenderManagerAccessor) MinecraftClient.getInstance().getBlockRenderManager()).callMethod_3592(GalvanistoOreBlock.stateFromData(itemStack.getMeta()), null);
		}
		return bakedModel;
	}

	@Inject(method = "method_3986", at = @At("RETURN"))
	public void registerStuff(CallbackInfo ci) {
		this.method_3977(GalvanistoIngotItem.instance(), OreVariant.COPPER.ordinal(), "copper_ingot");
		this.method_3977(GalvanistoIngotItem.instance(), OreVariant.ALUMINIUM.ordinal(), "aluminium_ingot");
		this.method_3977(GalvanistoIngotItem.instance(), OreVariant.SILVER.ordinal(), "silver_ingot");
	}
}
