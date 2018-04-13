package disc.mods.alternativeai.proxy;

import disc.mods.alternativeai.init.Entities;
import disc.mods.core.proxy.base.IProxyBase;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy implements IProxyBase {

	@Override
	public void initConfiguration(FMLPreInitializationEvent event) {
	}

	@Override
	public void registerEventHandlers() {
	}

	@Override
	public void registerCapabilities() {

	}

	@Override
	public void registerEntities() {
		Entities.init();
	}
}