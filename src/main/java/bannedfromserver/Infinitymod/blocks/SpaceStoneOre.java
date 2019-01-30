package bannedfromserver.Infinitymod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SpaceStoneOre extends BlockBase {

	public SpaceStoneOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);    //Block sounds like stone when walked on
		setHardness(5.0f);                //How hard it is to break with hand
		setResistance(15.0f);             //Resistance to explosives
		setHarvestLevel("pickaxe",2);     //Tool required for breaking it
	}
}
