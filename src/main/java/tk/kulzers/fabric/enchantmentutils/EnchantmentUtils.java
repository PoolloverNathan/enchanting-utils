package tk.kulzers.fabric.enchantmentutils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class EnchantmentUtils implements ModInitializer {
	RedstoneEnchantingTable REDSTONE_ENCHANTING_TABLE = new RedstoneEnchantingTable(AbstractBlock.Settings.of(Material.STONE));
	ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(Identifier.tryParse("enchantmentutils:tab"))
			.icon(() -> new ItemStack(REDSTONE_ENCHANTING_TABLE))
			.build();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Teaching machines how to harness magic");

		Registry.register(Registry.BLOCK, "enchantmentutils:enchanting_table", REDSTONE_ENCHANTING_TABLE);
		Registry.register(Registry.ITEM, "enchantmentutils:enchanting_table", new BlockItem(REDSTONE_ENCHANTING_TABLE, new Item.Settings().group(ITEM_GROUP)));

		System.out.println("Machines now know how to harness magic");
	}
}
