package me.luval.client.impl.modules;

import org.lwjgl.input.Keyboard;

import me.luval.client.api.event.EventTarget;
import me.luval.client.api.event.events.EventUpdate;
import me.luval.client.api.module.Category;
import me.luval.client.api.module.Module;

public class Flight extends Module{

	public Flight() {
		super("Flight", Keyboard.KEY_F, Category.MOVE, "Flighs. Use Hypixel Mode for Hypixel and Vanilla for non-ac or SP");
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		mc.thePlayer.capabilities.isFlying = true;
	}
	
	@Override
	public void onDisable()
	{
		mc.thePlayer.capabilities.isFlying = false;
		
		super.onDisable();
	}
}
