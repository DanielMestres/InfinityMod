package bannedfromserver.Infinitymod.tileentities;

import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityTeleporter extends TileEntity implements ITickable {
	
	public ItemStackHandler inventory = new ItemStackHandler(1) {
		// Missing methods?
	};
	
	private int id;
	private int usagesLeft;
	private int range;

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		compound.setInteger("id", id);
		compound.setInteger("usagesLeft", usagesLeft);
		compound.setInteger("range", range);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		id = compound.getInteger("id");
		usagesLeft = compound.getInteger("usagesLeft");
		range = compound.getInteger("range");
		super.readFromNBT(compound);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}
	
	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
	}
	
	// Executes 20 times a second
	@Override
	public void update() {
		// Executes if item in slot is a iron ingot, gold ingot or a diamond, make it so each give different amount of usages
		if(inventory.getStackInSlot(0).getItem().equals(Items.IRON_INGOT) || inventory.getStackInSlot(0).getItem().equals(Items.GOLD_INGOT) || inventory.getStackInSlot(0).getItem().equals(Items.DIAMOND))
		{
			// Increments usageLeft by 1 if its an iron ingot
			if(inventory.getStackInSlot(0).getItem().equals(Items.IRON_INGOT)) {
				incrementUsagesLeft();
				inventory.getStackInSlot(0).shrink(1);
				markDirty();
			}
			
			// Increments usageLeft by 3 if its a gold ingot
			if(inventory.getStackInSlot(0).getItem().equals(Items.GOLD_INGOT)) {
				incrementUsagesLeft();
				incrementUsagesLeft();
				incrementUsagesLeft();
				inventory.getStackInSlot(0).shrink(1);
				markDirty();
			}
			
			// Increments usageLeft by 5 if its a diamond
			if(inventory.getStackInSlot(0).getItem().equals(Items.DIAMOND)) {
				incrementUsagesLeft();
				incrementUsagesLeft();
				incrementUsagesLeft();
				incrementUsagesLeft();
				incrementUsagesLeft();
				inventory.getStackInSlot(0).shrink(1);
				markDirty();
			}
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public void incrementId() {
		this.id++;
		markDirty();
	}
	
	public void decrementId() {
		if(id <= 0)
			id = 0;
		else
			id--;
		markDirty();
	}
	
	public int getUsagesLeft() {
		return this.usagesLeft;
	}
	
	public void incrementUsagesLeft() {
		usagesLeft++;
		markDirty();
	}
	
	public void decrementUsagesLeft() {
		if(usagesLeft <= 0)
			usagesLeft = 0;
		else
			usagesLeft--;
		markDirty();
	}
	
	public int getRange() {
		return this.range;
	}
	
	public void setRange(int value) {
		if(value <= 0)
			range = 1;
		else
			range = value;
		markDirty();
	}
}
