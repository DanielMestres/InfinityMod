package bannedfromserver.Infinitymod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Tesseract extends BlockBase {

	public Tesseract(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);    //Block sounds like stone when walked on
		setHardness(3.0f);                //How hard it is to break with hand
		setResistance(6000.0f);           //Resistance to explosives
		setHarvestLevel("pickaxe",3);     //Item required for breaking it
		setLightLevel(300.0f);		      //Light that glows during breaking (kind of like redstone)
	}
}
