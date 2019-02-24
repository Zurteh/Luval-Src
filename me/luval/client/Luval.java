package me.luval.client;

import org.lwjgl.opengl.Display;

import me.luval.client.api.event.EventManager;
import me.luval.client.api.module.Module;
import me.luval.client.api.module.ModuleManager;
import me.luval.client.impl.utils.Logger;

public enum Luval {
	/*
	 * Huge Thanks to Hexception for EventManager, Data, ArrayHelper, Event, EventTarget. Priority
	 * Huge Thanks 
	 */
	
	INSTANCE;
	public static boolean premium = true;
	public String CLIENT_NAME = "Luval";
	public String CLIENT_THANK_YOU = "Thank you for purchasing Luval Premium!";
	public final double CLIENT_VERSION = 1.0;
	public final String CLIENT_DEVELOPER = "Jamie";
	public String CLIENT_TITLE = CLIENT_NAME + " | " + CLIENT_VERSION;
	public String CLIENT_PREMIUM_TITLE = CLIENT_NAME + " Premium Edition | " + CLIENT_VERSION;
	
	public Logger logger;
	public EventManager EVENT_MANAGER;
	public ModuleManager MODULE_MANAGER;
	public SettingManager SETTING_MANAGER;
	
	public void onLaunch() {
		if(premium = false) {
		Display.setTitle(CLIENT_TITLE);
		}
		else {
			Display.setTitle(CLIENT_PREMIUM_TITLE);
		}
		
		Logger.startLoadingClient();
		
		logger = new Logger();
		EVENT_MANAGER = new EventManager();
		MODULE_MANAGER = new ModuleManager();
		SETTING_MANAGER = new SettingManager();
		
		Logger.finishingClient();
	}
	

}


