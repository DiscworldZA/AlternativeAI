package disc.mods.alternativeai.capabilities.entityholder;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class EntityHolderStorage implements Capability.IStorage<IEntityHolder> {
	@Nullable
	@Override
	public NBTBase writeNBT(Capability<IEntityHolder> capability, IEntityHolder instance, EnumFacing side) {
		return instance.getEntity().serializeNBT();
	}

	@Override
	public void readNBT(Capability<IEntityHolder> capability, IEntityHolder instance, EnumFacing side, NBTBase nbt) {
		if (nbt instanceof NBTTagCompound) {
			instance.getEntity().deserializeNBT((NBTTagCompound) nbt);
		}
	}
}
