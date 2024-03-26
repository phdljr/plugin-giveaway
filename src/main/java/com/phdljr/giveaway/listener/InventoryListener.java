package com.phdljr.giveaway.listener;

import com.phdljr.giveaway.command.UserCommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void clickHotTimeInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        String inventoryTitle = event.getView().getOriginalTitle();
        if (!inventoryTitle.equalsIgnoreCase(UserCommandExecutor.HOT_TIME_INV_TITLE)) {
            return;
        }

        event.setCancelled(true);

        if (event.getSlot() == UserCommandExecutor.CLOSE_SLOT_NUM) {
            player.closeInventory();
        }
    }
}
