import java.io.*;

abstract class Plan {
	protected double rate;
	abstract void getRate();
	public void calculateBill(int units) {
		System.out.println(units*rate);
	}
}
class DomesticPlan extends Plan {
	public void getRate() {
		rate = 3.50;
	}
}
class CommercialPlan extends Plan {
	public void getRate() {
		rate = 7.50;
	}
class InstitutionalPlan extends Plan {
	public void getRate() {
		rate = 5.50;
	}
}
class GetPlanFactory {
	public Plan getPlan(String planType) {
		if(planType == null) {
			return null;
		}
		if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
			return new DomesticPlan();
		}
		if(planType.equalsIgnoreCase("COMMERCIALPLAN")) {
			return new CommercialPlan();
		}
		if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
			return new InstitutionalPlan();
		}
	return null;
	}
}
class GenerateBill {
	public void main (String args[]) throws IOException {
		GetPlanFactory planFactory = new GetPlanFactory();
		System.out.print("Enter the name of the plan for which the bill will be generated: ");
		int units = Integer.parseInt(br.readLine());
		Plan p = planFactory.getPlan(String planName);
		System.out.print("Bill ammount for "+planName+" of "+units+" units is: ");
		p.getRate();
		p.calculateBill(units);
	}
}

