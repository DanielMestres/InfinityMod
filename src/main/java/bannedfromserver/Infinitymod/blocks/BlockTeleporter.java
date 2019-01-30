package bannedfromserver.Infinitymod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import bannedfromserver.Infinitymod.Main;
import bannedfromserver.Infinitymod.gui.GuiHandler;
import bannedfromserver.Infinitymod.tileentities.TileEntityBase;
import bannedfromserver.Infinitymod.tileentities.TileEntityTeleporter;

import java.util.ArrayList;
import javax.annotation.Nullable;

public class BlockTeleporter extends TileEntityBase<TileEntityTeleporter> {
	
	// Constructor
	public BlockTeleporter() {
		super(Material.ROCK, "teleporter");
		setCreativeTab(CreativeTabs.TRANSPORTATION);
		setHardness(3.0f);
		setResistance(6000.0f);
		setHarvestLevel("pickaxe",3);
		setSoundType(SoundType.STONE);
	}
	
	// Gets called when right clicking the block
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		TileEntityTeleporter tile = getTileEntity(world, pos);
		
		// Sets teleporter range
		tile.setRange(8);
		
		// List for storing pos of blocks in range, stores every pos in a square around the block the size of its range
		ArrayList<BlockPos> radius = new ArrayList<BlockPos>();
	    for(int x = (tile.getRange() * -1); x <= tile.getRange(); x++) {
	        for(int y = (tile.getRange() * -1); y <= tile.getRange(); y++) {
	            for(int z = (tile.getRange() * -1); z <= tile.getRange(); z++) {
	                // Grab the current pos
	                radius.add(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
	            }
	        }
	    }
		
		// Executes if player is sneaking, increments id when clicking at the top and decreases it when on the bottom, fix id resetting
		if (!world.isRemote && player.isSneaking()) {
			if (side == EnumFacing.DOWN) {
				tile.decrementId();
			} else if (side == EnumFacing.UP) {
				tile.incrementId();
			}
			// Outputs teleporter id and its usages left with respective  x, y and z coordinates
			player.sendMessage(new TextComponentString("[X= " + pos.getX() + ", Y= " + pos.getY() + ", Z= " + pos.getZ() + "]" + " Teleporter [Id: " + tile.getId() + ", " +  "Usages Left: " + tile.getUsagesLeft() + "]"));
		}
		
		// Executes if player is not sneaking and not holding a blaze rod
		if (!world.isRemote && !player.isSneaking() && player.inventory.getCurrentItem().getItem() != Items.BLAZE_ROD) {
			// Opens teleporter gui
			player.openGui(Main.instance, GuiHandler.TELEPORTER, world, pos.getX(), pos.getY(), pos.getZ());
		}
		
		// Executes if player is holding a blaze rod
		if (!world.isRemote && !player.isSneaking() && player.inventory.getCurrentItem().getItem() == Items.BLAZE_ROD) {
			// Checks if usagesLeft is greater than zero
			if (tile.getUsagesLeft() > 0) {
				// Iterates through every pos in list
				for (BlockPos pos1: radius)
				{
					// Checks if tileentity in pos1 is a teleporter and it isn't the same teleporter
					if(world.getTileEntity(pos1) instanceof TileEntityTeleporter && world.getTileEntity(pos1) != tile) {
						TileEntityTeleporter tile1 = getTileEntity(world, pos1);
						
						// Checks if id of teleporter in pos1 is the same as teleporter in pos
						if(tile1.getId() == tile.getId())
						{
							// Teleports player to above the teleporter and decrements usagesLeft
							player.attemptTeleport(pos1.getX(), pos1.getY() + 2, pos1.getZ());
							tile.decrementUsagesLeft();
						}
					}
				}
			}
		}
		
		return true;
	}
	
	// Gets called when the block breaks, gives items back
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityTeleporter tile = getTileEntity(world, pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack = itemHandler.getStackInSlot(0);
		if (!stack.isEmpty()) {
			EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
			world.spawnEntity(item);
		}
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public Class<TileEntityTeleporter> getTileEntityClass() {
		return TileEntityTeleporter.class;
	}
	
	@Nullable
	@Override
	public TileEntityTeleporter createTileEntity(World world, IBlockState state) {
		return new TileEntityTeleporter();
	}
}
