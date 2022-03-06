package alterstepix.mythicrpg;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.util.Vector;

public class Events implements Listener {

    @EventHandler
    public void OnEntityBreedEvent(EntityBreedEvent e)
    {
        Player player = (Player)e.getBreeder();
        Vector vector = new Vector(0,1,0);
        player.setVelocity(vector);
    }

    @EventHandler
    public void PlayerBucketEntityEvent(PlayerBucketEntityEvent event)
    {
        Player player = (Player) event.getEntityBucket();
        player.getInventory().getItemInMainHand().getItemMeta().setDisplayName("Imbatasher");
    }

}
