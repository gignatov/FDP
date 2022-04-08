import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Food {
	public String prepareFood();
	public double foodPrice();
}

public class VegFood implements Food {
	public String prepareFood() {
		return "Veg Food";
	}
	public double foodPrice() {
		return 50.0;
	}
}

public abstract class FoodDecorator implements Food {
	private Food newFood;
	public FoodDecorator(Food newFood) {
		this.newFood = newFood;
	}
	
	@Override
	public String prepareFood() {
		return newFood.prepareFood();
	}
	
	@Override
	public double foodPrice() {
		return newFood.foodPrice();
	}
}

public class NonVegFood extends FoodDecorator {
	public NonVegFood(Food newFood) {
		super(newFood);
	}
	public String prepareFood() {
		return super.prepareFood() + " With Roasted Chicken and Chicken Curry ";
	}
	public double foodPrice() {
		return super.foodPrice() + 150.0;
	}
}

public class ChineseFood extends FoodDecorator {
	public ChineseFood(Food newFood) {
		super(newFood);
	}
	public String prepareFood() {
		return super.prepareFood() + " With Fried Rice and Manchurian ";
	}
	public double foodPrice() {
		return super.foodPrice() + 65.0;
	}
}

public class DecoratorPatternCustomer {
	private static int choice;
	public static void main(String args[]) throws NumberFormatException, IOException {
		do {
			System.out.println("========== Food Menu ========== \n");
			System.out.println("			1. Vegetarian Food.	 \n");
			System.out.println("			2. Non-Vegetarian Food. \n");
			System.out.println("			3. Chinese Food.		 \n");
			System.out.println("			4. Exit						 \n");
			System.out.println("Enter your choice: ");
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1: {
				VegFood vf = new VegFood();
				System.out.println(vf.prepareFood());
				System.out.println(vf.foodPrice());
				}
			break;
			case 2: {
				Food f1 = new NonVegFood((Food) new VegFood());
				System.out.println(f1.prepareFood());
				System.out.println(f1.foodPrice());
				}
			break;
			case 3: {
				Food f2 = new ChineseFood((Food) new VegFood());
				System.out.println(f2.prepareFood());
				System.out.println(f2.foodPrice());
				}
			break;
			default: {
				System.out.println("Other than these no food available");
				}
			return;
			}
		}
		while(choice != 4);
	}
}