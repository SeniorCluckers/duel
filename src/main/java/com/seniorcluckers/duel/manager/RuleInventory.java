package com.seniorcluckers.duel.manager;

import com.seniorcluckers.duel.OptionItemStack;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

public class RuleInventory {

    private final Inventory inventory;
    private final Set<OptionItemStack> optionItemStacks = new HashSet<>();

    public RuleInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Set<OptionItemStack> getOptionItemStacks() {
        return optionItemStacks;
    }


}
