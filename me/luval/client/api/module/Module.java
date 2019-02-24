package me.luval.client.api.module;

import org.lwjgl.input.Keyboard;

import me.luval.client.Luval;
import net.minecraft.client.Minecraft;

public class Module {
	protected static Minecraft mc = Minecraft.getMinecraft();
	
	public boolean toggled, visible;
	
	private String name, description;
	private int key, color;
	private Category category;
	
	//Super Module
	public Module(String name, int key, Category category, String description, int color) {
		this.name = name;
		this.key = key;
		this.category = category;
		this.description = description;
		this.color = color;
		toggled = false;
		visible = true;
	}
	
	//PRIMARY
	public Module(String name, int key, Category category, String description) {
		this.name = name;
		this.key = key;
		this.category = category;
		this.description = description;
		this.color = 0xFFFFFF;
		toggled = false;
		visible = true;
	}
	
	public Module(String name, int key, Category category) {
		this.name = name;
		this.key = key;
		this.category = category;
		this.description = "null";
		this.color = 0xFFFFFF;
		toggled = false;
		visible = true;
	}
	
	public Module(String name, int key, Category category, int color) {
		this.name = name;
		this.key = key;
		this.category = category;
		this.description = "null";
		this.color = color;
		toggled = false;
		visible = true;
	}
	
	public Module(String name) {
		this.name = name;
		this.key = Keyboard.KEY_NONE;
		this.category = Category.NONE;
		this.description = "null";
		this.color = 0xFFFFFF;
		toggled = false;
		visible = true;
	}
	
	public void onEnable() {Luval.INSTANCE.EVENT_MANAGER.register(this);}
	public void onDisable() {Luval.INSTANCE.EVENT_MANAGER.unregister(this);}
	public void onToggle() {}
	
	public void toggle() {
		toggled= !toggled;
		onToggle();
		if(toggled)
			onEnable();
		else
			onDisable();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setup() {}
	public void onRender() {}
	
	

}
