package disc.mods.alternativeai.ai.tasks;

import disc.mods.alternativeai.ai.entity.EntityLivingAI;
import disc.mods.core.util.queue.IQueueHandler;
import disc.mods.core.util.queue.SimpleObjectQueue;

public class AITasks extends SimpleObjectQueue<AITask, EntityLivingAI> {
	public AITasks(IQueueHandler handler) {
		super(handler);
	}

	@Override
	public void add(AITask t)
	{
		super.add(t);
		t.queueActions();
	}
}
