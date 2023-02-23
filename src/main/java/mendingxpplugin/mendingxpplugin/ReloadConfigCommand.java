package mendingxpplugin.mendingxpplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ReloadConfigCommand implements CommandExecutor {

    String prefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "MendingXP" + ChatColor.GRAY + "] ";

    private final Plugin plugin;

    public ReloadConfigCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mendingxpreload")) {
            if (sender.hasPermission("mendingxp.reload")) {
                plugin.reloadConfig();
                sender.sendMessage(prefix + ChatColor.GREEN + "Configuration reloaded.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return false;
            }
        }
        return false;
    }
}
