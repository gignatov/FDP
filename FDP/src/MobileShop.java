import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public interface MobileShop {
	public void modelNo();
	public void price();
}

public class Iphone implements MobileShop {
	
	@Override
	public void modelNo() {
		System.out.println(" Iphone 6 ");
	}
	
	@Override
	public void price() {
		System.out.println(" Rs 65000.00 ");
	}
}

public class Samsung implements MobileShop {
	
	@Override
	public void modelNo() {
		System.out.println(" Samsung Galaxy Tab 3 ");
	}
	
	@Override
	public void price() {
		System.out.println(" Rs 45000.00 ");
	}
}

public class Blackberry implements MobileShop {
	
	@Override
	public void modelNo() {
		System.out.println(" BlackBerry Z10 ");
	}
	
	@Override
	public void price() {
		System.out.println(" Rs 55000.00 ");
	}
}

public class ShopKeeper {
	private MobileShop iphone;
	private MobileShop samsung;
	private MobileShop blackberry;
	private ShopKeeper() {
		iphone = new Iphone();
		samsung = new Samsung();
		blackberry = new Blackberry();
	}
	public void iphoneSale() {
		iphone.modelNo();
		iphone.price();
	}
	public void samsungSale() {
		samsung.modelNo();
		samsung.price();
	}
	public void blackberrySale() {
		blackberry.modelNo();
		blackberry.price();
	}	
}

public class FacadePatternClient {
	private static int choice;
	public static void main(String args[]) throws NumberFormatException, IOException {
		do {
			System.out.println("========== Mobile Shop ========== \n");
			System.out.println("			1. IPHONE.	 \n");
			System.out.println("			2. SAMSUNG. \n");
			System.out.println("			3. BLACKBERRY.		 \n");
			System.out.println("			4. Exit						 \n");
			System.out.println("Enter your choice: ");
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			choice = Integer.parseInt(br.readLine());
			ShopKeeper sk = new ShopKeeper();
			switch(choice) {
			case 1: {
				sk.iphoneSale();
				}
			break;
			case 2: {
				sk.samsungSale();
				}
			break;
			case 3: {
				sk.blackberrySale();
				}
			break;
			default: {
				System.out.println("You purchased nothing");
				}
			return;
			}
		}
		while(choice != 4);
	}
}