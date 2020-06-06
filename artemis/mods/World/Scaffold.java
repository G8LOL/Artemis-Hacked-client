package artemis.mods.World;

import artemis.Category;
import artemis.module;

public class Scaffold extends module{

	public Scaffold() {
		super("Scaffold", "Places blocks under you", 0, 4, Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			
		}
	}
}
