package disc.mods.alternativeai.capabilities.entityholder;

import net.minecraft.entity.player.EntityPlayer;

public interface IEntityHolder {
	void setEntity(EntityPlayer entity);

	EntityPlayer getEntity();
}
