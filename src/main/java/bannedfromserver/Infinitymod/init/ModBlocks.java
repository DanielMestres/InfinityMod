package bannedfromserver.Infinitymod.init;

import java.util.ArrayList;
import java.util.List;

import bannedfromserver.Infinitymod.blocks.Tesseract;
import bannedfromserver.Infinitymod.blocks.BlockTeleporter;
import bannedfromserver.Infinitymod.blocks.SpaceStoneOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block TESSERACT =  new Tesseract("tesseract", Material.REDSTONE_LIGHT);
	public static final Block SPACE_STONE_ORE = new SpaceStoneOre("space_stone_ore", Material.ROCK);
	
	// Main feature
	public static final BlockTeleporter TELEPORTER = new BlockTeleporter();
}
