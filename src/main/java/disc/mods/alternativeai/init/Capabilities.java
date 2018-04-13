package disc.mods.alternativeai.init;

import disc.mods.alternativeai.capabilities.entityholder.EntityHolder;
import disc.mods.alternativeai.capabilities.entityholder.EntityHolderProvider;
import disc.mods.alternativeai.capabilities.entityholder.EntityHolderStorage;
import disc.mods.alternativeai.capabilities.entityholder.IEntityHolder;
import disc.mods.alternativeai.ref.References;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("unused")
public class Capabilities {
	@CapabilityInject(IEntityHolder.class)
	public static Capability<IEntityHolder> ENTITY_HOLDER_CAPABILITY = null;

	public static void init() {
		CapabilityManager.INSTANCE.register(IEntityHolder.class, new EntityHolderStorage(), EntityHolder::new);
	}

	@SubscribeEvent
	public void attachCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
		if (event.getObject() != null && event.getObject().getItem().equals(Items.EntityMoveItem.getItem())) {
			event.addCapability(new ResourceLocation(References.Mod.Id, "EntityHolder"), new EntityHolderProvider());
		}
	}
}
