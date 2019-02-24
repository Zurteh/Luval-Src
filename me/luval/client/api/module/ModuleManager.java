package me.luval.client.api.module;

import java.util.ArrayList;

import com.google.common.collect.ArrayListMultimap;

import me.luval.client.impl.modules.*;

public class ModuleManager {
	private ArrayList<Module> modules = new ArrayList<Module>();
	
	public ModuleManager() {
		addModule(new Sprint());
		addModule(new Flight());
		addModule(new HUD());
	}
	
	public boolean addModule(Module module) {
		return modules.add(module);
	}
	
    public Module getModuleByName(String name) {
        for(Module m : modules) {
        	if((m.getName().trim().equalsIgnoreCase(name)) || (m.toString().trim().equalsIgnoreCase(name.trim()))) {
        		return m;
        	}
        }
        return null;
    }
    
    public ArrayList<Module> getModules() {
    	return modules;
    }
}