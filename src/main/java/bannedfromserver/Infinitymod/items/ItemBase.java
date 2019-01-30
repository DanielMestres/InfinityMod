package bannedfromserver.Infinitymod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.init.ModItems;
import bannedfromserver.Infinitymod.util.IHasModel;

public class ItemBase extends Item implements IHasModel {
	
	// constructor
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		
		// sets item to material tab of inventory
		setCreativeTab(CreativeTabs.MATERIALS);
		
		// adds the item to the list of items
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		// registers the item
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
