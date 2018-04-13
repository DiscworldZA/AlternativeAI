package disc.mods.alternativeai.ai.actions;

import disc.mods.alternativeai.utils.NavigationHelper;
import net.minecraft.util.math.BlockPos;

public class MoveAction extends AIAction {

	private BlockPos destination;

	public MoveAction(BlockPos destination) {
		this.destination = destination;
	}

	@Override
	public boolean shouldExecute() {
		return !NavigationHelper.IsEntityCloseTo(handler, destination);
	}

	@Override
	public boolean continueExecuting() {
		return !NavigationHelper.IsEntityCloseTo(handler, destination);
	}

	@Override
	public void startExecuting() {

	}

	@Override
	public boolean updateAction() {
		return NavigationHelper.NavigateEntityTo(handler, destination);
	}

	@Override
	public void resetAction() {
		handler.getNavigator().clearPath();
	}
}
