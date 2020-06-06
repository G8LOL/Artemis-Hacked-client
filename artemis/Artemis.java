package artemis;

import artemis.Tab.TabGui;
import artemis.altmanager.AltManager;
import artemis.command.CommandManager;
import artemis.mods.Combat.*;
import artemis.mods.Movement.*;
import artemis.mods.Exploit.*;
import artemis.mods.Minigames.*;
import artemis.mods.Other.*;
import artemis.mods.Render.*;
import artemis.mods.World.*;
import artemis.mods.Player.*;


import artemis.settings.SettingsManager;
//import artemis.tabgui.TabGui;
import artemis.ui.HUD;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

public class Artemis {
	
  public static String Name = "Artemis";
  
  public static String version = "1.0";
  

  public static HUD hud = new HUD();
  //public static TabGui tabgui = new TabGui();
 // public static HUD2 hud2 = new HUD2();
  public static PlayerStats stats = new PlayerStats();
  public static ArmorStats armorStats = new ArmorStats();
  public static Nametags nametags = new Nametags();
  public static void stratup() {
    Display.setTitle(String.valueOf(Name) + " v" + version);
    
  }
  public static SettingsManager settingsManager;
  public static ModuleManager moduleManager;
  
  private static ArrayList<module> mods;
  private static CommandManager cmdManager;

  public static Artemis instance = new Artemis();

public static AltManager altManager;
  public final TabGui TAB = new TabGui();
  
  public Artemis() {
	  
	 settingsManager = new SettingsManager();
	 moduleManager = new ModuleManager();
	 mods = new ArrayList<module>();
	 cmdManager = new CommandManager();

	 
	 
	 addMod((module)new Fly());
	 addMod((module)new Sprint());
	 addMod((module)new Nofall());
	 addMod((module)new Fullbright());
	 addMod((module)new Sneak());
	 addMod((module)new Hypixelfly());
	 addMod((module)new Killaura());
	 addMod((module)new ClickGUI());
	 addMod((module)new ChestStealer());
	 addMod((module)new AutoClicker());
	 addMod((module)new PlayerWarner());
	 addMod((module)new Step());
	 addMod((module)new Antibot());
	 addMod((module)new AutoArmor());
	 addMod((module)new ServerCrasher());
	 addMod((module)new SpartanGlide());
	 addMod((module)new Bhop());
	 addMod((module)new AutoPotion());
	 addMod((module)new MurderMystery());
	 addMod((module)new InvManager());
	 addMod((module)new SlimeJump());
	 addMod((module)new FastLadder());
	 addMod((module)new ShaderESP());
	 addMod((module)new HighJump());
	 addMod((module)new Speed());
	 addMod((module)new Phase());
	 addMod((module)new LongJump());
	 addMod((module)new Criticals());
	 addMod((module)new AutoGap());
	 addMod((module)new Spammer());
	 addMod((module)new Velocity());
	 addMod((module)new Eagle());
	 addMod((module)new TPaura());
	 addMod((module)new PlayerStats());
	 addMod((module)new Cubecraftfly());
	 addMod((module)new Nametags());
	 addMod((module)new Jargon());
	 addMod((module)new ArmorStats());
	 addMod((module)new InstantRespawn());
	 addMod((module)new BedGodMode());
	 addMod((module)new InventoryMove());
	 addMod((module)new Tower());
	 addMod((module)new CubecraftLongJump());
	 addMod((module)new BedBreaker());
	 addMod((module)new ESP());
	 addMod((module)new ChestESP());
	 addMod((module)new ItemESP());
	 addMod((module)new GodMode());
	 
  }
  
  public static void addMod(module M) {
    mods.add(M);
  }
  
  public static ArrayList<module> getModules() {
    return mods;
  }
  
  public static void onUpdate() {
    for (module m : mods)
      m.onUpdate(); 
  }
  
  public static void onRender() {
    for (module m : mods)
      m.onRender(); 
  }
  

  
  public static void onKeyPressed(int k) {
	    for (module m : mods) {
	      if (m.getKey() == k)
	        m.toggle(); 
	    } 
	  }
	public static void addChatMessage(String s){
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("[§eArtemis§f] " + s));
	}

	public static boolean onSendChatMessage(String s){//EntityPlayerSP
		if(s.startsWith(".")){
			cmdManager.callCommand(s.substring(1));
			return false;
		}
		for(module m: getModules()){
			if(m.isToggled()){
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}

	public static boolean onRecieveChatMessage(S02PacketChat packet){
		for(module m: getModules()){
			if(m.isToggled()){
				return m.onRecieveChatMessage(packet);
			}
		}
		return true;
	}
	}


