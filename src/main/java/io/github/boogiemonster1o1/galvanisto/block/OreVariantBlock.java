package io.github.boogiemonster1o1.galvanisto.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.state.StateManager;

public abstract class OreVariantBlock extends Block {
	protected OreVariantBlock(Material material) {
		super(material);
	}

	@Override
	protected StateManager appendProperties() {
		return new StateManager(this, OreVariant.VARIANT_PROPERTY);
	}
}
