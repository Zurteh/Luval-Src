package me.luval.client.api.event.events;

import me.luval.client.api.event.Event;

public class Event3D extends Event{
	//EntityRenderer "hand"
	private float partialTicks;
	
	public Event3D(float partialTicks) {
		this.partialTicks = partialTicks;
	}

	public float getPartialTicks() {
		return partialTicks;
	}

}
