package disc.mods.alternativeai.capabilities.entityholder;

import disc.mods.alternativeai.init.Capabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityHolderProvider implements ICapabilitySerializable<NBTTagCompound> {

	private IEntityHolder instance = Capabilities.ENTITY_HOLDER_CAPABILITY.getDefaultInstance();

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == Capabilities.ENTITY_HOLDER_CAPABILITY;
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
		return hasCapability(capability, facing) ? Capabilities.ENTITY_HOLDER_CAPABILITY.cast(instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return (NBTTagCompound) Capabilities.ENTITY_HOLDER_CAPABILITY.getStorage().writeNBT(Capabilities.ENTITY_HOLDER_CAPABILITY, instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		Capabilities.ENTITY_HOLDER_CAPABILITY.getStorage().readNBT(Capabilities.ENTITY_HOLDER_CAPABILITY, instance, null, nbt);
	}
}
