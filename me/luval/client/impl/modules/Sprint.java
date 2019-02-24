package me.luval.client.impl.modules;

import org.lwjgl.input.Keyboard;

import me.luval.client.api.event.EventTarget;
import me.luval.client.api.event.events.EventUpdate;
import me.luval.client.api.module.Category;
import me.luval.client.api.module.Module;

public class Sprint extends Module{

	public Sprint() {
		super("Sprint", Keyboard.KEY_I, Category.MOVE, "AutoSprints for you");
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if((mc.thePlayer.moveForward > 0) && (mc.thePlayer.getFoodStats().getFoodLevel() > 6)) {
			mc.thePlayer.setSprinting(true);
		}
	}
	
	@Override
	public void onEnable() {
		if((mc.thePlayer.moveForward > 0) && (mc.thePlayer.getFoodStats().getFoodLevel() > 6)) {
			mc.thePlayer.setSprinting(true);
		}
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
		
		super.onDisable();
	}

}
