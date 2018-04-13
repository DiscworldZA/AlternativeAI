package disc.mods.alternativeai.ai.actions;

import disc.mods.alternativeai.utils.NavigationHelper;
import net.minecraft.entity.Entity;

public class FollowAction extends AIAction {

	private Entity entityFollow;

	public FollowAction(Entity entityFollow) {
		this.entityFollow = entityFollow;
	}

	@Override
	public boolean shouldExecute() {
		return !NavigationHelper.IsEntityCloseTo(handler, entityFollow.getPosition());
	}

	@Override
	public void startExecuting() {
		NavigationHelper.NavigateEntityTo(handler, entityFollow.getPosition());
	}

	@Override
	public boolean updateAction() {
		return NavigationHelper.NavigateEntityTo(handler, entityFollow.getPosition());
	}
}
