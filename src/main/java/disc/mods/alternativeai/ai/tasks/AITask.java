package disc.mods.alternativeai.ai.tasks;

import disc.mods.alternativeai.ai.actions.AIAction;
import disc.mods.alternativeai.ai.actions.AIActions;
import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import disc.mods.core.util.queue.IQueueable;

public abstract class AITask implements IQueueable<EntityLivingAI> {

	protected EntityLivingAI handler;
	public AIActions aiActions;

	public abstract void queueActions();

	public abstract boolean shouldExecute();

	public abstract boolean canBeFulfilled();

	public void startExecuting() {

	}

	public boolean updateTask() {
		boolean updated = aiActions.current.updateAction();
		if (!aiActions.current.continueExecuting()) {
			if (aiActions.hasNext())
				aiActions.pop().startExecuting();
		}
		return updated;
	}

	public boolean shouldContinueExecuting() {
		return aiActions.hasNext();
	}

	public void resetTask() {
		aiActions.all().forEach(AIAction::resetAction);
	}

	@Override
	public void setHandler(EntityLivingAI handler) {
		this.handler = handler;
		aiActions = new AIActions(handler);
	}
}
