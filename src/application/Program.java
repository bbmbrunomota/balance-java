package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import models.Excepcition.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String name = sc.next();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double limit = sc.nextDouble();
		System.out.println();
		
		Account account = new Account(number, name, balance, limit);
		System.out.println("Initial Balance:" + account.toString());
		System.out.println("==============================================================================================================");
		System.out.print("Você quer depositar ? (s/n) ");
		char deposito = sc.next().charAt(0);
		System.out.println("==============================================================================================================");
		if (deposito == 's') {
			System.out.print("Quanto voce quer depositar ? ");
			double dinheiro = sc.nextDouble();
			account.deposit(dinheiro);				
			System.out.println("==============================================================================================================");
		}
			System.out.println("Balance after deposit:" + account.toString());	
			System.out.println("==============================================================================================================");
		try {
			System.out.print("Enter amount for Withdraw : ");
			double amount = sc.nextDouble();
			account.witraw(amount);
			System.out.println("==============================================================================================================");
			System.out.println("After Balance: " + account.toString());
		} catch (BusinessException e) {
			System.out.println("==============================================================================================================");
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}