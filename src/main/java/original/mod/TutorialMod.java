package original.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import original.mod.lists.Blocklist;
import original.mod.lists.Itemlist;

@Mod("firstmod")
public class TutorialMod 
{
	public static TutorialMod instance; 
	public static final String modid = "firstmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final Itemgroup Myfirst = new Itemgroup();
	
	public TutorialMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);

	}

	private void setup(final FMLCommonSetupEvent event) {
		
	logger.info("Setup method registered");
	
}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		
	logger.info("clientRegistries method registered");
	
	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					Itemlist.yoru = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("yoru")),
					
					Itemlist.ruby_block = new ItemBlock(Blocklist.ruby_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(Blocklist.ruby_block.getRegistryName())
			);
			logger.info("Blocks registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					Blocklist.ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(4).sound(SoundType.SLIME)).setRegistryName(location("ruby_block"))
			);
			logger.info("items registered");
		}
		private static ResourceLocation location(String name) 
		{
			
		return new ResourceLocation(modid, name);
		
		}
	}
}
