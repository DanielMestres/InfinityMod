package bannedfromserver.Infinitymod.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.init.ModItems;
import bannedfromserver.Infinitymod.util.IHasModel;

public class ToolSword extends ItemSword implements IHasModel {
	
	// constructor
	public ToolSword(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
			
		// sets item to Combat tab of inventory
		setCreativeTab(CreativeTabs.COMBAT);
			
		// adds the item to the list of items
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		// registers the item
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
