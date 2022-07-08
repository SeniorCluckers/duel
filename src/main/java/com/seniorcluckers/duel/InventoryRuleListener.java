package com.seniorcluckers.duel;

import com.seniorcluckers.duel.manager.InventoryManager;
import com.seniorcluckers.duel.match.Rule;
import com.seniorcluckers.duel.pdc.DataContainer;
import com.seniorcluckers.duel.pdc.DataType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryRuleListener implements Listener {

    /**
     * In charge of handling the inventory listeners
     * @param e
     */
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (InventoryManager.getInstance().getInventories().contains(e.getClickedInventory())) {
            e.setCancelled(true);

            if (!(e.getWhoClicked() instanceof Player))
                return;

            if (e.getCurrentItem() == null)
                return;

            Inventory inventory = e.getClickedInventory();
            ItemStack itemStack = e.getCurrentItem();
            ItemMeta itemMeta = itemStack.getItemMeta();

            if (itemMeta != null) {
                DataContainer dataContainer = itemMeta.getPersistentDataContainer()
                        .get(OptionItemStack.DATA_KEY, new DataType());
                updateItemStack(dataContainer.getRule(), dataContainer.isToggled(), itemStack, itemMeta);
                player.sendMessage("Rule: " + dataContainer.getRule() + "\nStatus: " + dataContainer.isToggled());
            }
        }

    }


    private void updateItemStack(Rule rule, boolean isEnabled, ItemStack itemStack, ItemMeta itemMeta) {
        itemMeta.getPersistentDataContainer().set(OptionItemStack.DATA_KEY,
                new DataType(), new DataContainer(rule, !isEnabled));
        itemStack.setItemMeta(itemMeta);

        if (!isEnabled)
            itemStack.setType(Material.GREEN_WOOL);
        else
            itemStack.setType(Material.RED_WOOL);
    }

}
