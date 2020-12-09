package io.github.boogiemonster1o1.galvanisto.block

import java.util

import net.minecraft.block.{Block, BlockState, Material}
import net.minecraft.item.{Item, ItemGroup, ItemStack}
import net.minecraft.state.StateManager
import net.minecraft.state.property.EnumProperty

object GalvanistoOreBlock extends Block(Material.STONE) {
	val instance: GalvanistoOreBlock.type = this
	val variant: EnumProperty[OreVariant] = EnumProperty.of("variant", classOf[OreVariant])

	setItemGroup(ItemGroup.BUILDING_BLOCKS)

	override def getMeta(state: BlockState): Int = {
		state.get(variant).ordinal()
	}

	override def getData(state: BlockState): Int = {
		state.get(variant).ordinal()
	}

	override def stateFromData(data: Int): BlockState = {
		getDefaultState.`with`(variant, OreVariant.values().apply(data))
	}

	override def appendProperties(): StateManager = {
		new StateManager(this, variant)
	}

	override def appendItemStacks(item: Item, group: ItemGroup, stacks: util.List[ItemStack]): Unit = {
		OreVariant.values().foreach((variant: OreVariant) => stacks.add(new ItemStack(item, 1, variant.ordinal())))
	}
}
