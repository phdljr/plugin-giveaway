package com.phdljr.giveaway.config;

import com.phdljr.giveaway.GiveAway;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Configuration {
    CONFIG;

    private static final String CONFIG_YML = "config.yml";

    private File file;
    private YamlConfiguration configuration;

    public void load() {
        File file = new File(GiveAway.getInstance().getDataFolder(), CONFIG_YML);

        if (!file.exists()) {
            GiveAway.getInstance().saveResource(CONFIG_YML, false);
        }

        configuration = new YamlConfiguration();
        configuration.options().parseComments(true);

        try {
            configuration.load(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
