package disc.mods.alternativeai.init;

import disc.mods.alternativeai.items.EntityMoveItem;
import disc.mods.core.init.IDiscItems;
import net.minecraft.item.Item;

public enum Items implements IDiscItems {
	EntityMoveItem(EntityMoveItem.class);

	private Item item;
	private Class<? extends Item> itemClass;

	Items(Class<? extends Item> itemClass) {
		this.itemClass = itemClass;
	}

	@Override
	public Class<? extends Item> getItemClass() {
		return itemClass;
	}

	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public void setItem(Item item) {
		this.item = item;
	}
}
