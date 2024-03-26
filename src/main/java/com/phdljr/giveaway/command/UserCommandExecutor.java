package com.phdljr.giveaway.command;

import com.phdljr.giveaway.config.Configuration;
import java.util.Arrays;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class UserCommandExecutor implements CommandExecutor {

    public static final String HOT_TIME_INV_TITLE = "핫타임";

    public static final int EXPLANATION_SLOT_NUM = 4;
    public static final int MY_COUNT_SLOT_NUM = 11;
    public static final int ALL_COUNT_SLOT_NUM = 15;
    public static final int CLOSE_SLOT_NUM = 17;

    // 반환값이 true이면 성공적으로 실행됐다는 의미
    @Override
    public boolean onCommand(
        @NotNull CommandSender commandSender,
        @NotNull Command command,
        @NotNull String label,
        @NotNull String[] args
    ) {
        if (!(commandSender instanceof Player player)) {
            return false;
        }

        ItemStack explanationButton = createItemStack(
            Material.STONE,
            "핫타임",
            "특정 시간대에 서버에 접속해 있는",
            "모든 플레이어들에게 일정한 보상을 주는 기능",
            "",
            "핫타임 보상: %s".formatted(Configuration.getString("reward.money"))
        );

        ItemStack myCountButton = createItemStack(
            Material.OAK_SIGN,
            "핫타임 보상 수령 횟수",
            "%d번".formatted(1)
        );

        ItemStack allCountButton = createItemStack(
            Material.OAK_SIGN,
            "핫타임 보상 수령 총 인원",
            "%d명".formatted(100)
        );

        ItemStack closeButton = createItemStack(
            Material.RED_WOOL,
            "나가기"
        );

        Inventory inventory = Bukkit.createInventory(player, 9 * 2,
            Component.text(HOT_TIME_INV_TITLE));
        inventory.setItem(EXPLANATION_SLOT_NUM, explanationButton);
        inventory.setItem(MY_COUNT_SLOT_NUM, myCountButton);
        inventory.setItem(ALL_COUNT_SLOT_NUM, allCountButton);
        inventory.setItem(CLOSE_SLOT_NUM, closeButton);

        player.openInventory(inventory);

        return true;
    }

    private ItemStack createItemStack(Material material, String title, String... lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text(title));
        List<TextComponent> components = Arrays.stream(lore)
            .map(Component::text)
            .toList();
        itemMeta.lore(components);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
