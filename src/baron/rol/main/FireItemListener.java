package baron.rol.main;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Listens for Entity Damage Event for checking and updating items
 * 
 * @author norab7
 *
 */
public class FireItemListener implements Listener {

	@EventHandler
	/**
	 * Check if item is of a specified type and then convert the item is needed
	 * 
	 * @param e
	 */
	public void onEntityDamage(EntityDamageEvent e) {

		if (e.getEntity() instanceof Item) {
			ItemStack fireItem = ((Item) e.getEntity()).getItemStack();

			if (FireItemIO.isBase(fireItem)) {
				e.setCancelled(true);
			}

			if (FireItemIO.isFireable(fireItem)) {
				FireItemIO.fireItem(fireItem);
			}
		}
	}
}
