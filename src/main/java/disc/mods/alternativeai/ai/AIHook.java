package disc.mods.alternativeai.ai;

import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import net.minecraft.entity.ai.EntityAIBase;

public class AIHook extends EntityAIBase {

	private EntityLivingAI handler;

	public AIHook(EntityLivingAI entity) {
		this.handler = entity;
	}

	@Override
	public boolean shouldExecute() {
		return handler.isServerWorld() && handler.aiTasks.hasNext() && handler.aiTasks.getNext().shouldExecute();
	}

	@Override
	public void startExecuting() {
		if (handler.isServerWorld()) {
			handler.aiTasks.pop();
		}
	}

	@Override
	public void updateTask() {
		if (handler.isServerWorld()) {
			if (!handler.aiTasks.current.updateTask()) {
				handler.aiTasks.pushBack();
				handler.aiTasks.pop();
			}
		}
	}

	@Override
	public boolean shouldContinueExecuting() {
		return handler.isServerWorld() && handler.aiTasks.current.shouldContinueExecuting();
	}

	@Override
	public void resetTask() {
		if (handler.isServerWorld()) {
			handler.aiTasks.current.resetTask();
		}
	}
}
