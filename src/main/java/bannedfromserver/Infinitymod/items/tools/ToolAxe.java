package bannedfromserver.Infinitymod.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.init.ModItems;
import bannedfromserver.Infinitymod.util.IHasModel;

public class ToolAxe extends ItemAxe implements IHasModel {
	
	// constructor
	public ToolAxe(String name, ToolMaterial material) {
		super(material, 6.0f, -3.2f);
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
