package disc.mods.alternativeai;

import disc.mods.alternativeai.ref.References;
import disc.mods.core.DiscMod;
import disc.mods.core.proxy.IProxy;
import disc.mods.core.proxy.base.IProxyBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = References.Mod.Id, name = References.Mod.Name, version = References.Mod.Version, dependencies = References.Mod.DependencyString)
public class AlternativeAI extends DiscMod {

	@SidedProxy(clientSide = References.Proxy.Client, serverSide = References.Proxy.Server)
	public static IProxy proxy;

	@Override
	public String getModId() {
		return References.Mod.Id;
	}

	@Override
	public IProxyBase proxy() {
		return proxy;
	}
}
