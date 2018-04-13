package disc.mods.alternativeai.capabilities.entityholder;

import net.minecraft.entity.player.EntityPlayer;

public class EntityHolder implements IEntityHolder {

	private EntityPlayer entity;

	@Override
	public void setEntity(EntityPlayer entity) {

	}

	@Override
	public EntityPlayer getEntity() {
		return entity;
	}
}
