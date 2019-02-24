package me.luval.client.impl.modules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.lwjgl.input.Keyboard;

import me.luval.client.Luval;
import me.luval.client.api.event.EventTarget;
import me.luval.client.api.event.events.Event2D;
import me.luval.client.api.gui.tabgui.TabGui;
import me.luval.client.api.module.Category;
import me.luval.client.api.module.Module;
import me.luval.client.impl.utils.RenderUtils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class HUD extends Module{

	public HUD() {
		super("HUD", Keyboard.KEY_H, Category.VISUALS, "Displays HUD");
	}
	
	private FontRenderer fr = mc.fontRendererObj;
	public static TabGui tabGui;
	
	@EventTarget
	public void onRender(Event2D event) {
		fr.drawString(Luval.INSTANCE.CLIENT_NAME, 2, 2, 0xFFFFFF);
		
		  int index = 0;
	        ScaledResolution sr = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
	        sr.getScaledWidth();
	        sr.getScaledHeight();
	        final FontRenderer fr = this.mc.fontRendererObj;
	        
	        int i = 0;
	        List<String> display = new ArrayList<String>();
	        for(Module m : Luval.INSTANCE.MODULE_MANAGER.getModules()) {
	        	if((m.isToggled()) && (m.visible)) {
	        		display.add(String.valueOf(m.getName()));
	        	}
	        	
	        	
	        }
	        
	        Collections.sort(Luval.INSTANCE.MODULE_MANAGER.getModules(), new Comparator<Module>() {

				@Override
				public int compare(Module mod1, Module mod2) {
					if(fr.getStringWidth(mod1.getName()) > fr.getStringWidth(mod2.getName())) {
						return -1;
					}
					
					if(fr.getStringWidth(mod1.getName()) < fr.getStringWidth(mod2.getName())) {
						return 1;
					}
					return 0;
				}
			});
	    	
	    	for(String s : display) {
	    		int x = 0;
	    		int mwidth = sr.getScaledWidth() - fr.getStringWidth(s) -2;
	    		int mheight = 10 * i + 2;
	    		
	    		fr.drawString(s, mwidth, mheight, 0xFFFFFFFF);
	    		i++;
	    		x++;
	    	}
	    	display.clear();
			
	}

}
