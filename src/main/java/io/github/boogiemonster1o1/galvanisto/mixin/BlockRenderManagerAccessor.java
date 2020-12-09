package io.github.boogiemonster1o1.galvanisto.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.util.math.BlockPos;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(BlockRenderManager.class)
public interface BlockRenderManagerAccessor {
	@Invoker
	BakedModel callMethod_3592(BlockState blockState, BlockPos blockPos);
}
