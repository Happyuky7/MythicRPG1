package alterstepix.mythicrpg.commands;

import alterstepix.mythicrpg.Mythicrpg;
import alterstepix.mythicrpg.util.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class GetMythicItems implements CommandExecutor {

    Mythicrpg main;

    public GetMythicItems(Mythicrpg main)
    {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Inventory gui = Bukkit.createInventory(null,InventoryType.CHEST);
        ItemManager m = new ItemManager(main);
        m.init();
        gui.addItem(m.LightingAxe);
        gui.addItem(m.IdolsIncarnate);
        gui.addItem(m.Terminator);
        gui.addItem(m.HealingSword);
        Player p = (Player)sender;
        p.openInventory(gui);
        return true;

    }
}
