package com.lockedme;

import java.util.List;
import java.util.Scanner;

public class HandleOptions {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				FileMenuOptions.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					DirFileOperations.displayAllFiles("main");
					break;
				case 2:
					HandleOptions.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("PROGRAM EXITED SUCCESSFULLY.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("PLEASE SELECT A VALID OPTION FROM ABOVE.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				FileMenuOptions.displayFileMenuOptions();
				DirFileOperations.createMainFolderIfNotPresent("main");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter The Name Of the File To Be Added To The \"main\" folder");
					String fileToAdd = sc.next();
					
					DirFileOperations.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter The Name Of The File To Be Deleted From \"main\" folder");
					String fileToDelete = sc.next();
					
					DirFileOperations.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = DirFileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\n Select Index Of Which File To Delete?"
							+ "\n(Enter 0 If You Want To Delete All Elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						DirFileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							DirFileOperations.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter The Name Of The File To Be Searched From \"main\" folder");
					String fileName = sc.next();
					
					DirFileOperations.createMainFolderIfNotPresent("main");
					DirFileOperations.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("PROGRAM EXITED SUCCESSFULLY.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from Above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
