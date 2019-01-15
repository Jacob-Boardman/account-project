package com.qa.account.application;

import com.qa.account.service.Service;

/**
 * Hello world!
 *
 */
public class App {
	
	private App() {};
	
	public static void main(String[] args) {
		Service service = new Service();
		Account a1 = new Account("Jacob", "Boardman", 123);
		Account a2 = new Account("Declan", "McGee", 456);
		Account a3 = new Account("Joseph", "Gurney", 789);
		
		service.addAccount(a1);
		service.addAccount(a2);
		service.addAccount(a3);
		
		System.out.println(service.getJSON());

	}
}
