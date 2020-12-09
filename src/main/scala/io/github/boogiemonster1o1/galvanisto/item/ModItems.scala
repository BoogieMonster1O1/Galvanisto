package io.github.boogiemonster1o1.galvanisto.item

import io.github.boogiemonster1o1.galvanisto.Galvanisto
import io.github.boogiemonster1o1.galvanisto.block.{GalvanistoOreBlock, OreVariant}
import net.fabricmc.fabric.api.content.registry.v1.ItemRegistry
import net.minecraft.item.{Item, ItemStack, VariantBlockItem}
import net.minecraft.recipe.{RecipeDispatcher, SmeltingRecipeRegistry}
import net.minecraft.util.Identifier

object ModItems {
	val oreItem: Item = new VariantBlockItem(GalvanistoOreBlock, GalvanistoOreBlock, (input: ItemStack) => {
		OreVariant.values().apply(input.getMeta).asString()
	})

	def init(): Unit = {
		ItemRegistry.register(new Identifier(Galvanisto.modId, "ore"), oreItem)
		ItemRegistry.register(new Identifier(Galvanisto.modId, "ingot"), GalvanistoIngotItem)
		SmeltingRecipeRegistry.getInstance().addItemStack(new ItemStack(GalvanistoOreBlock, 1, OreVariant.ALUMINIUM.ordinal()), new ItemStack(GalvanistoIngotItem, 1, OreVariant.ALUMINIUM.ordinal()), 0.7F)
		SmeltingRecipeRegistry.getInstance().addItemStack(new ItemStack(GalvanistoOreBlock, 1, OreVariant.COPPER.ordinal()), new ItemStack(GalvanistoIngotItem, 1, OreVariant.COPPER.ordinal()), 0.7F)
		SmeltingRecipeRegistry.getInstance().addItemStack(new ItemStack(GalvanistoOreBlock, 1, OreVariant.SILVER.ordinal()), new ItemStack(GalvanistoIngotItem, 1, OreVariant.SILVER.ordinal()), 0.7F)
	}
}
