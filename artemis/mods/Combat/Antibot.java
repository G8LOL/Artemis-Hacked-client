package artemis.mods.Combat;

 
import java.util.Random;

import javax.swing.event.DocumentEvent.EventType;

import org.lwjgl.input.Keyboard;

import artemis.Category;
import artemis.module;
import artemis.util.TimeUtils;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Keyboard;
 
public class Antibot extends module {
    public Antibot() {
        super("Antibot", "Removes anticheat bots from game", Keyboard.KEY_TAB, 1, Category.OTHER);
    }
 
    public void onDisable() {
        super.onDisable();
      }
    
    public void onUpdate() {
        if (isToggled()) {
        	for(Object entity : mc.theWorld.loadedEntityList)
                if(((Entity)entity).isInvisible() && entity != mc.thePlayer) {
                    mc.theWorld.removeEntity((Entity)entity);
            }
        }
 }
}
