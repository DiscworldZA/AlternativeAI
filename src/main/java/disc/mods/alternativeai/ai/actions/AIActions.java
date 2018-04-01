package disc.mods.alternativeai.ai.actions;

import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import disc.mods.core.util.queue.IQueueHandler;
import disc.mods.core.util.queue.SimpleObjectQueue;

public class AIActions extends SimpleObjectQueue<AIAction, EntityLivingAI> {
	public AIActions(IQueueHandler handler) {
		super(handler);
	}
}
