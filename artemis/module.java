package artemis;

import java.util.Iterator;

import artemis.notification.Notification;
import artemis.notification.NotificationManager;
import artemis.notification.NotificationType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.S02PacketChat;

public class module {
	
	protected Minecraft mc = Minecraft.getMinecraft();
	protected String name;
	private String discription;
	private int key, id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private boolean toggled;
	private Category category;
	private boolean isEnabled;
	public boolean visible = false;
	
	public module(String nm, String discription, int k, int id, Category c){
		name = nm;
		this.discription = discription;
		key = k;
		this.id = id;
		category = c;
		toggled = false;
		setup();
	}
	
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public void toggle(){
		toggled = !toggled;
		if(toggled){
			onEnable();
		}else{
			onDisable();
		}
	}
	
	public void onEnable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Info", name + " was enabled", 2));
		 for(Iterator<Object> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
	          Object theObject = entities.next();
	          if(theObject instanceof EntityLivingBase) {
	              EntityLivingBase entity = (EntityLivingBase) theObject;
	             
	              if(entity instanceof EntityPlayerSP) continue;
	             
	              if(mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
	                  if(entity.isEntityAlive()) {
	                	  NotificationManager.show(new Notification(NotificationType.WARNING, "WARNING!", " Entity near you!", 2));
	                  }
                   }
	          }
		 }
		 for(Object entity : mc.theWorld.loadedEntityList)
             if(((Entity)entity).isInvisible() && entity != mc.thePlayer) {
            	 NotificationManager.show(new Notification(NotificationType.ERROR, "WARNING!", "Watchdog detected!", 2));
             }
	}
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Info", name + " was disabled", 2));
	}
	public void onUpdate(){}
	public void onRender(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory(){
		return category;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	public final boolean isCategory(Category s) {
		if (s == category)
			return true;
		return false;
	}
	public boolean getState() {
		return isEnabled;
	}
	
	public void setState(boolean state) {
		this.toggle();
		if (state) {
			this.onEnable();
			this.isEnabled = true;
		} else {
			this.onDisable();
			this.isEnabled = false;
		}
	}
	
	public boolean onSendChatMessage(String s){
		return true;
	}
	
	public boolean onRecieveChatMessage(S02PacketChat packet){
		return true;
	}

	public void setup() {
		
		
	}
	
	
	

}