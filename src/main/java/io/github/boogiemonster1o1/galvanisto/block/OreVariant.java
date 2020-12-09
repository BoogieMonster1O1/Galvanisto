package io.github.boogiemonster1o1.galvanisto.block;

import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public enum OreVariant implements StringIdentifiable {
	COPPER,
	SILVER,
	ALUMINIUM;
	public static final EnumProperty<OreVariant> VARIANT_PROPERTY = EnumProperty.of("variant", OreVariant.class);

	@Override
	public String asString() {
		return this.name().toLowerCase();
	}

	@Override
	public String toString() {
		return this.asString();
	}
}
