package io.github.boogiemonster1o1.galvanisto.block

import java.util

import net.minecraft.block.{BlockState, Material}
import net.minecraft.item.{Item, ItemGroup, ItemStack}

object GalvanistoOreBlock extends OreVariantBlock(Material.STONE) {
	val instance: GalvanistoOreBlock.type = this

	setItemGroup(ItemGroup.BUILDING_BLOCKS)

	override def getMeta(state: BlockState): Int = {
		state.get(OreVariant.VARIANT_PROPERTY).ordinal()
	}

	override def getData(state: BlockState): Int = {
		state.get(OreVariant.VARIANT_PROPERTY).ordinal()
	}

	override def stateFromData(data: Int): BlockState = {
		getDefaultState.`with`(OreVariant.VARIANT_PROPERTY, OreVariant.values().apply(data))
	}

	override def appendItemStacks(item: Item, group: ItemGroup, stacks: util.List[ItemStack]): Unit = {
		OreVariant.values().foreach((variant: OreVariant) => stacks.add(new ItemStack(item, 1, variant.ordinal())))
	}
}
