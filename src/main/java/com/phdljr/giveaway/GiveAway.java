package com.phdljr.giveaway;

import com.phdljr.giveaway.command.AdminCommandExecutor;
import com.phdljr.giveaway.command.UserCommandExecutor;
import com.phdljr.giveaway.config.Configuration;
import com.phdljr.giveaway.listener.InventoryListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class GiveAway extends JavaPlugin {

    private static final String ON_MESSAGE = "활성화";
    private static final String OFF_MESSAGE = "비활성화";

    private static final String COMMAND_GIVEAWAY = "giveaway";
    private static final String COMMAND_GIVEAWAY_ADMIN = "giveawayadmin";

    public static Plugin getInstance() {
        return getPlugin(GiveAway.class);
    }

    @Override
    public void onEnable() {
        getLogger().info(ON_MESSAGE);

        Configuration.load();
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getCommand(COMMAND_GIVEAWAY).setExecutor(new UserCommandExecutor());
        getCommand(COMMAND_GIVEAWAY_ADMIN).setExecutor(new AdminCommandExecutor());
    }

    @Override
    public void onDisable() {
        getLogger().info(OFF_MESSAGE);
    }
}
