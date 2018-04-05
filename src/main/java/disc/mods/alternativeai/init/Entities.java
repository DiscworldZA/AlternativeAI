package disc.mods.alternativeai.init;

import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import disc.mods.alternativeai.ai.entity.EntityLumberjack;
import disc.mods.alternativeai.client.renderer.entity.RenderHumanoid;
import disc.mods.alternativeai.ref.References;
import disc.mods.core.DiscMod;
import disc.mods.core.util.ResourceLocationHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.Random;

public class Entities {
	public static int modEntityId = 0;

	protected static void RegisterEntity(Class<? extends EntityLivingAI> entity, String Name) {
		long x = entity.getName().hashCode();
		Random random = new Random(x);
		int eggPrimary = random.nextInt() * 16777215; // first egg color
		int eggSecondary = random.nextInt() * 16777215;
		EntityRegistry.registerModEntity(ResourceLocationHelper.getEntityLocation(References.Mod.Id, Name), entity, Name, modEntityId, DiscMod.instance(), 64, 1, true, eggPrimary, eggSecondary);
		modEntityId++;
	}

	public static void init() {
		RegisterEntity(EntityLumberjack.class, References.Entity.Lumberjack);
	}

	public static void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLumberjack.class, RenderHumanoid::new);
	}
}
