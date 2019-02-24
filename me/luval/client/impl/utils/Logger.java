package me.luval.client.impl.utils;

import me.luval.client.api.file.CustomFile;
import me.luval.client.api.module.Module;

public class Logger {
	public static void LoadingModule(Module module) {
		System.out.println("Loading Module: " + module);
	}
	
	public static void SavingClientFiles(CustomFile file) {
		System.out.println("Saving File: " + file);
	}
	
	public static void startLoadingClient() {
		System.out.println("Loading Client");
	}
	
	public static void loadingClientFiles(CustomFile file) {
		System.out.println("Loading File: " + file);
	}
	
	public static void finishingClient() {
		System.out.println("Finished Loading Client");
	}

}
