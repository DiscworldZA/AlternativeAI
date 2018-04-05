package disc.mods.alternativeai.ai.entity;

import disc.mods.alternativeai.ref.References;
import disc.mods.core.util.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityLumberjack extends EntityHumanoidAI {

	public EntityLumberjack(World worldIn) {
		super(worldIn);
	}

	@Override
	public ResourceLocation getTexture() {
		return ResourceLocationHelper.getEntityLocation(References.Mod.Id, References.Entity.Lumberjack + ".png");
	}

	@Override
	public int getInventorySize() {
		return 32;
	}
}
