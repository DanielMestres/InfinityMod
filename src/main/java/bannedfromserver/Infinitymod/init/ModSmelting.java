package bannedfromserver.Infinitymod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmelting {

	public static void init(){
		GameRegistry.addSmelting(ModBlocks.SPACE_STONE_ORE, new ItemStack(ModItems.SPACE_STONE, 2), 10.0f);
	}
}
