package com.seniorcluckers.duel;

import com.seniorcluckers.duel.match.Rule;
import com.seniorcluckers.duel.pdc.DataContainer;
import com.seniorcluckers.duel.pdc.DataType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OptionItemStack extends ItemStack implements Listener {

    public static final NamespacedKey DATA_KEY = new NamespacedKey(Duel.getInstance(), "data");

    public OptionItemStack(@NotNull final Material type, Rule rule, boolean def) {
        super(type);
        initDataContainer(rule, def);
    }

    public OptionItemStack(ItemStack item) {
        super(item.getType(), item.getAmount());
        this.setItemMeta(item.getItemMeta());
    }

    private void initDataContainer(Rule rule, boolean def) {
        checkHasMeta();
        ItemMeta meta = this.getItemMeta();
        meta.getPersistentDataContainer().set(DATA_KEY, new DataType(), new DataContainer(rule, def));
        this.setItemMeta(meta);
    }

    public DataContainer getPersistentData() {
        checkHasMeta();
        ItemMeta meta = this.getItemMeta();
        return meta.getPersistentDataContainer().get(DATA_KEY, new DataType());
    }

    private void checkHasMeta() {
        if (!this.hasItemMeta()) {
            this.setItemMeta(Bukkit.getItemFactory().getItemMeta(this.getType()));
        }
    }

}
