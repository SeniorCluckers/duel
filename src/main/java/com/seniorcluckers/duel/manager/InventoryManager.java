package com.seniorcluckers.duel.manager;

import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

public class InventoryManager {

    private static InventoryManager instance = null;

    private final Set<Inventory> inventories = new HashSet<>();

    private InventoryManager() {}

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }
}
