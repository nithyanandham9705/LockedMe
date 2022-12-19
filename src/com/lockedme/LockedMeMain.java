package com.lockedme;

public class LockedMeMain {

	public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		DirFileOperations.createMainFolderIfNotPresent("main");
		
		FileMenuOptions.printWelcomeScreen("LockedMe", "Aman Shrivastava");
		
		HandleOptions.handleWelcomeScreenInput();
	}

	
}
