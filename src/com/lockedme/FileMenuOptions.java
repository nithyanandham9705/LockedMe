package com.lockedme;

public class FileMenuOptions {

	public static void printWelcomeScreen(String appName, String developerName) {
		String companyDetails = String.format("*****************************************************\n"
				+ "** Welcome To %s.com. \n" + "** This Application Was Developed By %s.\n"
				+ "*****************************************************\n", appName, developerName);
		String appFunction = "Usage Of This Application Is To: \n"
				+ "• Retrieve All File Names In The \"main\" folder\n"
				+ "• Search, Add, Or Delete Files In \"main\" folder.\n"
				+ "\n**Please Be Careful To Ensure The Correct Filename Is Provided For Searching Or Deleting Files.**\n";
		System.out.println(companyDetails);

		System.out.println(appFunction);
	}

	public static void displayMenu() {
		String menu = "\n\n****** Select Any Option No From Below And Press Enter ******\n\n"
				+ "1] Retrieve Fll Files Inside \"main\" folder in ascending order\n" + "2] Display Menu For File Operations\n"
				+ "3] Exit Program\n";
		System.out.println(menu);

	}

	public static void displayFileMenuOptions() {
		String fileMenu = "\n\n****** Select Any Option Number From Below And Press Enter ******\n\n"
				+ "1] Add A File To \"main\" folder\n" + "2] Delete A File From \"main\" folder\n"
				+ "3] Search For A File From \"main\" folder\n" + "4] Navigate Back To Main Application\n" + "5] Exit Program\n";

		System.out.println(fileMenu);
	}

}
