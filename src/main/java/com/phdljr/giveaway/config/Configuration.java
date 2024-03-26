package com.phdljr.giveaway.config;

import com.phdljr.giveaway.GiveAway;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Configuration {

    private static final String CONFIG_YML = "config.yml";
    private static final Plugin PLUGIN = GiveAway.getInstance();

    public static void load() {
        File file = new File(GiveAway.getInstance().getDataFolder(), CONFIG_YML);

        if (!file.exists()) {
            PLUGIN.saveResource(CONFIG_YML, false);
        }

        YamlConfiguration configuration = new YamlConfiguration();
        configuration.options().parseComments(true);

        try {
            configuration.load(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getString(String path) {
        return PLUGIN.getConfig().getString(path);
    }
}
