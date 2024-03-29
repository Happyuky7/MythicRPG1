package alterstepix.mythicrpg.commands;

import alterstepix.mythicrpg.Mythicrpg;
import alterstepix.mythicrpg.util.ItemLoreLibrary;
import alterstepix.mythicrpg.managers.ItemManager;
import alterstepix.mythicrpg.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppendAbilityLore implements CommandExecutor, TabCompleter {

    Mythicrpg main;
    ItemManager m;
    FileConfiguration config;
    ItemLoreLibrary lib;
    public AppendAbilityLore(Mythicrpg main)
    {
        this.main = main;
        m = new ItemManager(main);
        m.init();
        this.config = main.getConfiguration();
        this.lib = new ItemLoreLibrary(main);
        this.lib.Init();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                if (p.isOp() || p.hasPermission("mythicrpg.addabilitylore")) {
                    ItemStack mainhand = p.getInventory().getItemInMainHand();
                    ItemMeta meta = mainhand.getItemMeta();
                    List<String> lore = new ArrayList<String>();
                            if (meta.hasLore())
                                lore = meta.getLore();

                    if(lib.Lore.get(args[0]) == null)
                    {
                        p.sendMessage("§c[mrpg] Unknown ability");
                        return true;
                    }

                    for(String l : lib.Lore.get(args[0]))
                        lore.add(l);

                    meta.setLore(lore);
                    mainhand.setItemMeta(meta);
                    p.getInventory().setItemInMainHand(mainhand);
                    p.sendMessage(Messages.CommandSuccess);

                    }
                    else
                    {
                        p.sendMessage(Messages.NotOperator);
                    }

                }

            }
        else{
            Bukkit.getLogger().info(Messages.NotPlayer);
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> Abilities = new ArrayList<>();

        ItemLoreLibrary ill = new ItemLoreLibrary(main);
        ill.Init();
        for(String key : ill.Lore.keySet())
        {
            if((key.toLowerCase(Locale.ROOT)).startsWith(args[0].toLowerCase(Locale.ROOT)))
            Abilities.add(key);
        }


        return Abilities;

    }
}
