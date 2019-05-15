package com.heroslender.herodungeons;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeroDungeons extends JavaPlugin {
    @Getter private static HeroDungeons instance;

    public HeroDungeons() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
