package io.github.boogiemonster1o1.galvanisto

import io.github.boogiemonster1o1.galvanisto.block.{GalvanistoOreBlock, ModBlocks}
import io.github.boogiemonster1o1.galvanisto.item.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.item.{ItemGroup, ItemStack, Items}
import net.minecraft.util.Identifier

object Galvanisto extends ModInitializer {
	val modId: String = "galvanisto"
	val version: String = FabricLoader.getInstance.getModContainer(modId).get.getMetadata.getVersion.toString
	val itemGroup: ItemGroup = FabricItemGroupBuilder.create(new Identifier(modId, "itemGroup")).icon(() => new ItemStack(GalvanistoOreBlock)).build

	override def onInitialize(): Unit = {
		println("Loading Galvanisto")
		ModBlocks.init()
		ModItems.init()
	}
}
