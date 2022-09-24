package com.project;

import java.util.Scanner;

import com.project.utility.AppManager;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello, welcome");

		boolean ifRunning = true;

		while (ifRunning) {
			AppManager.availableOptions();

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if (!AppManager.evaluteChoice(choice)) {
				AppManager.wrongChoiceAlert();
			}
		}
	}
}