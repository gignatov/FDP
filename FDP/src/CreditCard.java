import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface CreditCard {
	public void giveBankDetails();
	public String getCreditCard();
}
public class BankDetails {
	private String bankName;
	private String accHolderName;
	private long accNumber;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName (String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
}

public class BankCustomer extends BankDetails implements CreditCard {
	public void giveBankDetails() {
		try {
			BufferReader br = new BufferReader(new InputStreamReader(System.in));
			System.out.print("Enter the account holder name :");
			String.customername = br.readLine();
			System.out.print("\n");
			System.out.print("Enter the bank name :");
			String bankname = br.readLine();
			setAccHolderName(customername);
			setAccNumber(accno);
			setBankName(bankname);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getCreditCard() {
		long accno = getAccNumber();
		String accholdername = getAccHolderName();
		String bname = getBankName();
		return ("The Account number "+accno+" of "+accholdername+" in "+bname+ " bank is valid and authenticaded for issuing the credit card.");
	}
}

public class AdapterPatterDemo {
	public static void main(String args[]) {
		CreditCard targetInterface = new BankCustomer();
		targetInterface.giveBankDetails();
		System.out.print(targetInterface.getCreditCard());
	}
}