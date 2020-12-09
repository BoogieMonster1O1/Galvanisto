package io.github.boogiemonster1o1.galvanisto.item

import java.util

import io.github.boogiemonster1o1.galvanisto.block.OreVariant
import net.minecraft.item.{Item, ItemGroup, ItemStack}

object GalvanistoIngotItem extends Item {
	def instance: GalvanistoIngotItem.type = this

	override def getTranslationKey(stack: ItemStack): String = {
		this.getTranslationKey + "." + OreVariant.fromItemStack(stack).asString
	}

	override def appendItemStacks(item: Item, group: ItemGroup, list: util.List[ItemStack]): Unit = {
		OreVariant.values.foreach((variant: OreVariant) => list.add(new ItemStack(this, 1, variant.ordinal())))
	}
}
