package original.mod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import original.mod.lists.Blocklist;
import original.mod.lists.Itemlist;

public class Itemgroup extends ItemGroup
{
	public Itemgroup() {
		super("Myfirst");
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Itemlist.yoru);

	}
}
