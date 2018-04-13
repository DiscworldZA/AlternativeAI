package disc.mods.alternativeai.ai.tasks;

import disc.mods.alternativeai.ai.actions.FollowAction;
import net.minecraft.entity.Entity;

public class FollowTask extends AITask {

	private Entity followEntity;

	public FollowTask(Entity followEntity) {
		this.followEntity = followEntity;
	}


	@Override
	public void queueActions() {
		this.aiActions.add(new FollowAction(followEntity));
	}

	@Override
	public boolean shouldExecute() {
		return true;
	}

	@Override
	public boolean canBeFulfilled() {
		return true;
	}
}
