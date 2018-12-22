package baron.rol.main;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Checks and conversions of any items specified in the configuration files.
 * 
 * @author norab7
 *
 */
public class FireItemIO {

	/**
	 * Checks item is of a base type
	 * 
	 * @param fireItem
	 * @return boolean
	 */
	public static boolean isBase(ItemStack fireItem) {

		if (FireItemMain.fireItems.keySet().contains(fireItem.getType().name())
				|| FireItemMain.fireItems.values().contains(fireItem.getType().name())) {
			return true;
		}

		return false;

	}

	/**
	 * Checks item has a next stage
	 * 
	 * @param fireItem
	 * @return
	 */
	public static boolean isFireable(ItemStack fireItem) {
		if (FireItemMain.fireItems.keySet().contains(fireItem.getType().name())) {
			return true;
		}
		return false;
	}

	/**
	 * Updates the material type of item to the next stage
	 * 
	 * @param fireItem
	 */
	public static void fireItem(ItemStack fireItem) {
		fireItem.setType(Material.getMaterial(FireItemMain.fireItems.get(fireItem.getType().name())));
	}
}
