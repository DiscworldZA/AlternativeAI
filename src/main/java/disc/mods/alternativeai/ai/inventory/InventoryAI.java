package disc.mods.alternativeai.ai.inventory;

import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import disc.mods.core.util.InventoryHelper;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

public class InventoryAI implements IItemHandler {
	protected EntityLivingAI entity;
	protected NonNullList<ItemStack> inventory;


	public InventoryAI(EntityLivingAI entity, int size) {
		this.entity = entity;
		inventory = NonNullList.withSize(size, ItemStack.EMPTY);
	}

	public void setHeldItem(EntityEquipmentSlot slot, ItemStack item) {
		ItemStack stackInSlot = entity.getItemStackFromSlot(slot);
		if (!stackInSlot.isEmpty()) {
			InventoryHelper.Add(this, stackInSlot);
			clearHeldItem(slot);
		}
		entity.setItemStackToSlot(slot, item);
	}

	public void clearHeldItem(EntityEquipmentSlot slot) {
		entity.setItemStackToSlot(slot, ItemStack.EMPTY);
	}

	public boolean hasItem(ItemStack stack) {
		for (int i = 0; i < this.getSlots(); i++) {
			if (getStackInSlot(i).isItemEqual(stack)) {
				return true;
			}
		}
		return false;
	}

	public ItemStack oreDictMatch(NonNullList<ItemStack> itemStacks) {
		for (ItemStack stack : itemStacks) {
			if (hasItem(stack)) {
				return stack;
			}
		}
		return ItemStack.EMPTY;
	}


	public void readFromNBT(NBTTagCompound compound) {
		ItemStackHelper.loadAllItems(compound, this.inventory);
	}

	public void writeToNBT(NBTTagCompound compound) {
		ItemStackHelper.saveAllItems(compound, this.inventory);
	}

	@Override
	public int getSlots() {
		return entity.getInventorySize();
	}

	@Nonnull
	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory.get(slot);
	}

	@Nonnull
	@Override
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
		ItemStack stackInSlot = inventory.get(slot);
		if (stackInSlot.isEmpty()) {
			inventory.set(slot, stack);
			return ItemStack.EMPTY;
		}
		if (!stackInSlot.isItemEqual(stack)) return stack;
		if (stackInSlot.getCount() + stack.getCount() > stackInSlot.getMaxStackSize()) {
			stack.setCount(stack.getCount() - stackInSlot.getCount());
			stackInSlot.setCount(stackInSlot.getMaxStackSize());
			if (!simulate) {
				inventory.set(slot, stackInSlot);
			}
			return stack;
		} else {
			if (!simulate) inventory.set(slot, stack);
			return ItemStack.EMPTY;
		}
	}

	@Nonnull
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		ItemStack stackInSlot = inventory.get(slot);
		if (stackInSlot.isEmpty()) {
			return ItemStack.EMPTY;
		}
		if (stackInSlot.getCount() + amount > 0) {
			stackInSlot.setCount(stackInSlot.getCount() - amount);
			if (!simulate) {
				inventory.set(slot, stackInSlot);
			}
			ItemStack newStack = stackInSlot.copy();
			newStack.setCount(amount);
			return newStack;
		} else {
			if (!simulate) inventory.set(slot, ItemStack.EMPTY);
			return stackInSlot;
		}
	}

	@Override
	public int getSlotLimit(int slot) {
		return inventory.get(slot).getMaxStackSize();
	}
}
