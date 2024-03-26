package com.phdljr.giveaway.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class UserCommandExecutor implements CommandExecutor {

    private FileConfiguration fileConfiguration;

    public UserCommandExecutor(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }

    // 반환값이 true이면 성공적으로 실행됐다는 의미
    @Override
    public boolean onCommand(
        @NotNull CommandSender commandSender,
        @NotNull Command command,
        @NotNull String s,
        @NotNull String[] strings
    ) {
        commandSender.sendMessage(fileConfiguration.getString("reward"));
        return false;
    }
}
