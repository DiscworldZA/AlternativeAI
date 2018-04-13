package disc.mods.alternativeai.items;

import disc.mods.alternativeai.init.Capabilities;
import disc.mods.core.creativetab.Tabs;
import disc.mods.core.items.CoreItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMoveItem extends CoreItem {

	public EntityMoveItem() {
		super("entitymoveitem", "entitymoveitem");
		this.setCreativeTab(Tabs.ItemsTab);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		player.getCapability(Capabilities.ENTITY_HOLDER_CAPABILITY, null).getEntity().getName();
		return super.onLeftClickEntity(stack, player, entity);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		String name = player.getCapability(Capabilities.ENTITY_HOLDER_CAPABILITY, null).getEntity().getName();
		System.out.println("Hi " + name);
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
}
