package io.github.boogiemonster1o1.galvanisto.item

import io.github.boogiemonster1o1.galvanisto.Galvanisto
import io.github.boogiemonster1o1.galvanisto.block.{GalvanistoOreBlock, OreVariant}
import net.fabricmc.fabric.api.content.registry.v1.ItemRegistry
import net.minecraft.item.{Item, ItemStack, VariantBlockItem}
import net.minecraft.util.Identifier

object ModItems {
	val oreItem: Item = new VariantBlockItem(GalvanistoOreBlock, GalvanistoOreBlock, (input: ItemStack) => {
		OreVariant.values().apply(input.getMeta).asString()
	})

	def init(): Unit = {
		ItemRegistry.register(new Identifier(Galvanisto.modId, "ore"), oreItem)
	}
}
