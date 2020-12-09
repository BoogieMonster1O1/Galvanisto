package io.github.boogiemonster1o1.galvanisto.block

import io.github.boogiemonster1o1.galvanisto.Galvanisto
import net.fabricmc.fabric.api.content.registry.v1.BlockRegistry
import net.minecraft.util.Identifier

object ModBlocks {
	def init(): Unit = {
		BlockRegistry.register(new Identifier(Galvanisto.modId, "ore"), GalvanistoOreBlock)
	}
}
