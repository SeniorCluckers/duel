package com.seniorcluckers.duel;

import com.seniorcluckers.duel.command.DuelCommand;
import com.seniorcluckers.duel.match.MatchManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Duel extends JavaPlugin {

    @Getter
    private static Duel instance;

    @Override
    public void onEnable() {
        this.instance = this;

        getServer().getPluginManager().registerEvents(new InventoryRuleListener(), this);

        // Plugin startup logic
        MatchManager.init();
        getCommand("duel").setExecutor(new DuelCommand());
    }

    // https://www.spigotmc.org/threads/extending-inventory-to-add-variables.524519/


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
