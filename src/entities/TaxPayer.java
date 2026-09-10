package entities;

public class TaxPayer {

	private static final double SALARY_TAX_LOW = 0.10;
	private static final double SALARY_TAX_HIGH = 0.20;
	private static final double SERVICES_TAX = 0.15;
	private static final double CAPITAL_TAX = 0.20;
	private static final double REBATE_LIMIT = 0.30;

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	private Double healthSpending;
	private Double educationSpending;

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public Double salaryTax() {

		double monthlyIncome = salaryIncome / 12;

		if (monthlyIncome >= 5000) {
			return salaryIncome * SALARY_TAX_HIGH;
		} else if (monthlyIncome >= 3000) {
			return salaryIncome * SALARY_TAX_LOW;
		}

		return 0.0;
	}

	public Double servicesTax() {
		return servicesIncome > 0 ? servicesIncome * SERVICES_TAX : 0.0;
	}

	public Double capitalTax() {
		return capitalIncome > 0 ? capitalIncome * CAPITAL_TAX : 0.0;
	}

	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public Double taxRebate() {
		double maxRebateValue = grossTax() * REBATE_LIMIT;
		double totalSpending = healthSpending + educationSpending;
		return totalSpending > maxRebateValue ? maxRebateValue : totalSpending;
	}

	public Double netTax() {
		return grossTax() - taxRebate();
	}

	public void printTaxesResume(int position) {
		System.out.printf("\nResumo do %do contribuinte: ", position);
		System.out.printf("\nImposto bruto total: %.2f", grossTax());
		System.out.printf("\nAbatimento: %.2f", taxRebate());
		System.out.printf("\nImposto devido: %.2f\n", netTax());
	}

}
