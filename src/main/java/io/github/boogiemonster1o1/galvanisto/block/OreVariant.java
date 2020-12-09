package io.github.boogiemonster1o1.galvanisto.block;

import net.minecraft.util.StringIdentifiable;

public enum OreVariant implements StringIdentifiable {
	COPPER,
	SILVER,
	ALUMINIUM;

	@Override
	public String asString() {
		return this.name().toLowerCase();
	}

	@Override
	public String toString() {
		return this.asString();
	}
}
