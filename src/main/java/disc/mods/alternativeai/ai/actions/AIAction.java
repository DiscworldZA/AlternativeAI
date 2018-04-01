package disc.mods.alternativeai.ai.actions;

import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import disc.mods.core.util.queue.IQueueable;

public abstract class AIAction implements IQueueable<EntityLivingAI> {
	protected EntityLivingAI handler;

	public abstract boolean shouldExecute();

	public abstract void startExecuting();

	public abstract boolean updateAction();

	public boolean continueExecuting() {
		return false;
	}

	public void resetAction() {

	}

	@Override
	public void setHandler(EntityLivingAI handler) {
		this.handler = handler;
	}
}
