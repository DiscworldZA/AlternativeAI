package disc.mods.alternativeai.ai.entity;

import disc.mods.alternativeai.ai.AIHook;
import disc.mods.alternativeai.ai.inventory.InventoryAI;
import disc.mods.alternativeai.ai.tasks.AITasks;
import disc.mods.core.util.queue.IQueueHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class EntityLivingAI extends EntityLiving implements IQueueHandler {

	public AITasks aiTasks;
	public InventoryAI inventory;

	public EntityLivingAI(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		aiTasks = new AITasks(this);
		this.tasks.addTask(0, new AIHook(this));
	}

	@Override
	public IQueueHandler getHandler() {
		return this;
	}

	public double getMovementSpeed() {
		return 0.42D;
	}

	public abstract ResourceLocation getTexture();

	public abstract int getInventorySize();
}
