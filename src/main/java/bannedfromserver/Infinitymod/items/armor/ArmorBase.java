package bannedfromserver.Infinitymod.items.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.init.ModItems;
import bannedfromserver.Infinitymod.util.IHasModel;

public class ArmorBase extends ItemArmor implements IHasModel {
	
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		// sets armor to combat tab of inventory
		setCreativeTab(CreativeTabs.COMBAT);
		
		// adds the armor to the list of items
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		// registers the item
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
