package com.seniorcluckers.duel.command;

import com.seniorcluckers.duel.OptionItemStack;
import com.seniorcluckers.duel.manager.InventoryManager;
import com.seniorcluckers.duel.manager.RuleInventory;
import com.seniorcluckers.duel.match.Rule;
import com.seniorcluckers.duel.pdc.DataContainer;
import com.seniorcluckers.duel.pdc.DataType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DuelCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 1) {
            Player dueler = (Player) sender;
            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {
                player.sendMessage(dueler.getDisplayName() + " has requested to duel you!");
                player.openInventory(createInventory(player.getDisplayName()));
            }
            return true;
        }

        return false;
    }

    private Inventory createInventory(String playerName) {

        Inventory inventory = Bukkit.createInventory(null,54,
                "1v1 Rules");

        RuleInventory ruleInventory = new RuleInventory(inventory);

        ItemStack diamondHelment = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack diamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS);

        ItemStack enchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE);
        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack potion = new ItemStack(Material.POTION);
        ItemStack food = new ItemStack(Material.COOKED_BEEF);

        // TODO Should we be able to disable types of potions and arrows?

        // Will disable all splash potions and special arrows
        ItemStack splashPotion = new ItemStack(Material.SPLASH_POTION);
        ItemStack specialArrow = new ItemStack(Material.SPECTRAL_ARROW);

        OptionItemStack redWoolHel = new OptionItemStack(Material.GREEN_WOOL, Rule.HELMET, true);
        OptionItemStack redWoolChest = new OptionItemStack(Material.GREEN_WOOL, Rule.CHEST_PLATE, true);
        OptionItemStack redWoolLeggings = new OptionItemStack(Material.GREEN_WOOL, Rule.LEGGINGS, true);
        OptionItemStack redWoolBoots = new OptionItemStack(Material.GREEN_WOOL, Rule.BOOTS, true);

        OptionItemStack redWoolSword = new OptionItemStack(Material.GREEN_WOOL, Rule.SWORD, true);
        OptionItemStack redWoolShield = new OptionItemStack(Material.GREEN_WOOL, Rule.SHIELD, true);
        OptionItemStack redWoolBow = new OptionItemStack(Material.GREEN_WOOL, Rule.BOW, true);
        OptionItemStack redWoolEnchantedApple = new OptionItemStack(Material.GREEN_WOOL, Rule.ENCHANTED_GOLDEN_APPLE, true);

        OptionItemStack redWoolGoldenApple = new OptionItemStack(Material.GREEN_WOOL, Rule.GOLDEN_APPLE, true);
        OptionItemStack redWoolFood = new OptionItemStack(Material.GREEN_WOOL, Rule.FOOD, true);
        OptionItemStack redWoolPotion = new OptionItemStack(Material.GREEN_WOOL, Rule.POTION, true);
        OptionItemStack redWoolSplashPotion = new OptionItemStack(Material.GREEN_WOOL, Rule.SPLASH_POTION, true);
        OptionItemStack redWoolSpecialArrow = new OptionItemStack(Material.GREEN_WOOL, Rule.SPECIAL_ARROW, true);

        inventory.setItem(0, diamondHelment);
        inventory.setItem(9, diamondChest);
        inventory.setItem(18, diamondLeggings);
        inventory.setItem(27, diamondBoots);

        // Enabled/Disabled For Armour
        inventory.setItem(1, redWoolHel);
        inventory.setItem(10, redWoolChest);
        inventory.setItem(19, redWoolLeggings);
        inventory.setItem(28, redWoolBoots);

        inventory.setItem(4, redWoolSword);
        inventory.setItem(13, redWoolShield);
        inventory.setItem(22, redWoolBow);
        inventory.setItem(31, redWoolEnchantedApple);

        inventory.setItem(3, sword);
        inventory.setItem(12, shield);
        inventory.setItem(21, bow);
        inventory.setItem(30, enchantedGoldenApple);
        inventory.setItem(6, goldenApple);

        inventory.setItem(15, food);
        inventory.setItem(24, potion);
        inventory.setItem(33, splashPotion);
        inventory.setItem(42, specialArrow);

        inventory.setItem(7, redWoolGoldenApple);
        inventory.setItem(16, redWoolFood);
        inventory.setItem(25, redWoolPotion);
        inventory.setItem(34, redWoolSplashPotion);
        inventory.setItem(43, redWoolSpecialArrow);

        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = inventory.getItem(i);

            if (item != null) {
                if (item.getItemMeta() != null) {
                    DataContainer dataContainer = item.getItemMeta().getPersistentDataContainer().get(OptionItemStack.DATA_KEY, new DataType());
                    if (dataContainer != null) {
                        if (dataContainer.getRule() != null)
                            System.out.println("Rule: " + dataContainer.getRule() + " found!");
                    }
                }
            }

//            if (!(item instanceof OptionItemStack ois)) {
//                if (item != null) {
//                    System.out.println(item.getType() + " isn't a OptionItemStack");
//                }
//                continue;
//            }
//            ois.addClickFunction((c) -> {
//                System.out.println("on click");
//                DataContainer data = c.getItemStack().getPersistentData();
//                data.setToggle(!data.isToggle());
//                c.getItemStack().setType(data.isToggle() ? Material.GREEN_WOOL : Material.RED_WOOL);
//            });
        }

        InventoryManager.getInstance().getInventories().add(ruleInventory.getInventory());

        return inventory;
    }

}
