package bannedfromserver.Infinitymod.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import bannedfromserver.Infinitymod.containers.ContainerTeleporter;
import bannedfromserver.Infinitymod.tileentities.TileEntityTeleporter;

public class GuiHandler implements IGuiHandler {
	
	// Id for teleporter gui
	public static final int TELEPORTER = 0;
	
	// Returns the right instance given the id, null otherwise
	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case TELEPORTER:
				return new ContainerTeleporter(player.inventory, (TileEntityTeleporter)world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}
	
	// Returns the right GuiScreen instance with the same data as getServerGuiElement
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case TELEPORTER:
				return new GuiTeleporter(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			default:
				return null;
		}
	}
}
