package artemis.mods.Combat;

import artemis.Category;
import artemis.Artemis;
import artemis.module;
import artemis.settings.Setting;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;
public class Killaura extends module {
  
  public Killaura() {
    super("Killaura", "Automatically hits entitys", Keyboard.KEY_P, 9, Category.COMBAT);
    
  }
  @Override
  public void onUpdate() {
     
      if(!this.isToggled())
          return;
     
      for(Iterator<Object> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
          Object theObject = entities.next();
          if(theObject instanceof EntityLivingBase) {
              EntityLivingBase entity = (EntityLivingBase) theObject;
             
              if(entity instanceof EntityPlayerSP) continue;
             if(!entity.isInvisible()) {
              if(mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
                  if(entity.isEntityAlive()) {
                	  if(entity.hurtTime < 10) {
                      mc.playerController.attackEntity(mc.thePlayer, entity);
                      mc.thePlayer.swingItem();
                      continue;
                  }
                  
              }
             }
          }
      }
     
      }
      super.onUpdate();
  }

}