package bannedfromserver.Infinitymod.tileentities;

import net.minecraftforge.fml.common.registry.GameRegistry;

import bannedfromserver.Infinitymod.tileentities.TileEntityTeleporter;

public class TileEntityHandler {
	
	@SuppressWarnings("deprecation")
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTeleporter.class, "teleporter");
	}
}
