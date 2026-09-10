package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("\nQuantos contribuintes você vai digitar? ");
		int numOfTaxPayers = sc.nextInt();

		List<TaxPayer> taxPayerList = new ArrayList<>();
		sc.nextLine();
		for (int i = 0; i < numOfTaxPayers; i++) {
			taxPayerList.add(createTaxPayer(sc, i+1));
		}

		for (int i = 0; i < taxPayerList.size(); i++) {
			taxPayerList.get(i).printTaxesResume(i+1);
		}

		sc.close();
	}

	public static TaxPayer createTaxPayer(Scanner sc, int position) {
		System.out.printf("\nDigite os dados do %do contribuinte: ", position);
		System.out.print("\nRenda anual com salário: ");
		double salaryIncome = sc.nextDouble();

		System.out.print("Renda anual com prestação de serviço: ");
		double servicesIncome = sc.nextDouble();

		System.out.print("Renda anual com ganho de capital: ");
		double capitalIncome = sc.nextDouble();

		System.out.print("Gastos médicos: ");
		double healthSpending = sc.nextDouble();

		System.out.print("Gastos educacionais: ");
		double educationSpending = sc.nextDouble();

		return new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
	}

}