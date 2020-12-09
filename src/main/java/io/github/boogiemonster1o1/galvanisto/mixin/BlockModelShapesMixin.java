package io.github.boogiemonster1o1.galvanisto.mixin;

import io.github.boogiemonster1o1.galvanisto.block.GalvanistoOreBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.client.BlockStateMap;
import net.minecraft.client.render.BlockStateIdentifierMapAccess;
import net.minecraft.client.render.block.BlockModelShapes;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(BlockModelShapes.class)
public abstract class BlockModelShapesMixin {
	@Shadow public abstract void method_3581(Block arg, BlockStateIdentifierMapAccess arg1);

	@Inject(method = "method_3587", at = @At("HEAD"))
	public void registerModBlockStates(CallbackInfo ci) {
		this.method_3581(GalvanistoOreBlock.instance(), new BlockStateMap.Builder().defaultProperty(GalvanistoOreBlock.variant()).suffix("_ore").build());
	}
}
