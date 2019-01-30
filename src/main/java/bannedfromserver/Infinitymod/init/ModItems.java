package bannedfromserver.Infinitymod.init;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import bannedfromserver.Infinitymod.items.ItemBase;
import bannedfromserver.Infinitymod.items.armor.ArmorBase;
import bannedfromserver.Infinitymod.items.tools.ToolAxe;
import bannedfromserver.Infinitymod.items.tools.ToolHoe;
import bannedfromserver.Infinitymod.items.tools.ToolPickaxe;
import bannedfromserver.Infinitymod.items.tools.ToolSpade;
import bannedfromserver.Infinitymod.items.tools.ToolSword;
import bannedfromserver.Infinitymod.util.Reference;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Materials
	public static final ToolMaterial MATERIAL_SPACE = EnumHelper.addToolMaterial("material_space", 3, 250, 8.0f, 3.0f, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_SPACE = EnumHelper.addArmorMaterial("armor_material_space", Reference.MOD_ID + ":space", 14, new int[] {2, 5, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f);
	
	// Items
	public static final Item SPACE_STONE = new ItemBase("space_stone");
	public static final Item SPACE_STONE_ACTIVE = new ItemBase("space_stone_active");
	
	// Tools & Weapons
	public static final ItemSword SPACE_SWORD = new ToolSword("space_sword", MATERIAL_SPACE);
	public static final ItemSpade SPACE_SHOVEL = new ToolSpade("space_shovel", MATERIAL_SPACE);
	public static final ItemPickaxe SPACE_PICKAXE = new ToolPickaxe("space_pickaxe", MATERIAL_SPACE);
	public static final ItemAxe SPACE_AXE = new ToolAxe("space_axe", MATERIAL_SPACE);
	public static final ItemHoe SPACE_HOE = new ToolHoe("space_hoe", MATERIAL_SPACE);
	
	// Armor
	public static final Item SPACE_HELMET = new ArmorBase("space_helmet", ARMOR_MATERIAL_SPACE, 1, EntityEquipmentSlot.HEAD);
	public static final Item SPACE_CHESTPLATE = new ArmorBase("space_chestplate", ARMOR_MATERIAL_SPACE, 1, EntityEquipmentSlot.CHEST);
	public static final Item SPACE_LEGGINGS = new ArmorBase("space_leggings", ARMOR_MATERIAL_SPACE, 2, EntityEquipmentSlot.LEGS);
	public static final Item SPACE_BOOTS = new ArmorBase("space_boots", ARMOR_MATERIAL_SPACE, 1, EntityEquipmentSlot.FEET);
}
	
