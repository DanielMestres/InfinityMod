package bannedfromserver.Infinitymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.init.ModBlocks;
import bannedfromserver.Infinitymod.init.ModItems;
import bannedfromserver.Infinitymod.util.IHasModel;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		// sets item to material tab of inventory
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		// adds the item to the list of items
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
