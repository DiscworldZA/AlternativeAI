package disc.mods.alternativeai.ref;

public class References {

	public static class Mod {
		public static final String Id = "alternativeai";
		public static final String Name = "Alternative AI";
		public static final String Version = "@VERSION@";
		public static final String DependencyString = "required-after:disccore";
	}

	public static class Proxy {
		public final static String Client = "disc.mods.alternativeai.proxy.ClientProxy";
		public final static String Server = "disc.mods.alternativeai.proxy.ServerProxy";
	}

	public static class Entity {
		public final static String Lumberjack = "lumberjack";
	}
}
