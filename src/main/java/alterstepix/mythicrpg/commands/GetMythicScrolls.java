package alterstepix.mythicrpg.commands;

import alterstepix.mythicrpg.Mythicrpg;
import alterstepix.mythicrpg.guis.ExperimentalMenu;
import alterstepix.mythicrpg.guis.ScrollsMenu;
import alterstepix.mythicrpg.util.Messages;
import alterstepix.mythicrpg.managers.ScrollManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class GetMythicScrolls implements CommandExecutor {
    Mythicrpg main;

    public GetMythicScrolls(Mythicrpg main)
    {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player)
        {
            if(sender.isOp() || sender.hasPermission("mythicrpg.getmythicscrolls"))
            {

                ScrollsMenu menu = new ScrollsMenu(Mythicrpg.getPMU(player));
                menu.open();
                player.sendMessage(Messages.CommandSuccess);
            }

        }
        else
        {
            Bukkit.getLogger().info(Messages.NotPlayer);
        }
        return true;
    }
}
