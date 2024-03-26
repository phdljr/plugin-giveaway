package com.phdljr.giveaway.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminCommandExecutor implements CommandExecutor {

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

        switch (args[0]) {
            case "run" -> runHotTime();
            case "runafter" -> runHotTimeAfter(Integer.parseInt(args[1]));
            case "cancel" -> cancel();
        }

        return true;
    }

    private void runHotTime() {

    }

    private void runHotTimeAfter(int second) {

    }

    private void cancel() {

    }
}
