package bannedfromserver.Infinitymod.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.init.ModItems;
import bannedfromserver.Infinitymod.util.IHasModel;

public class ToolHoe extends ItemHoe implements IHasModel {
	
	// constructor
	public ToolHoe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
							
		// sets item to tools tab of inventory
		setCreativeTab(CreativeTabs.TOOLS);
							
		// adds the item to the list of items
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		// registers the item
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
