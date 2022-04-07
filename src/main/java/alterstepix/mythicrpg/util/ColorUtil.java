package alterstepix.mythicrpg.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

public class ColorUtil {

    public static String ConvertToCustom(String text)
    {
        String finalText = "";

            if(text.split("!").length == 2)
            {
                finalText = (ChatColor.of(text.split("!")[0]) + text.split("!")[1]);
            }
            else
            {
                Bukkit.getLogger().info("[mrpg] Cannot read the custom name");
                Bukkit.getLogger().info("Name was "+text+" args length - "+text.split("!").length);
            }

        return finalText;
    }
}
