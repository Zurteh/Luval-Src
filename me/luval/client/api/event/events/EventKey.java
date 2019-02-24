package me.luval.client.api.event.events;

import me.luval.client.api.event.Event;

public class EventKey extends Event{
	private int key;
	
	public EventKey(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

}
