import java.util.List;
import java.util.ArrayList;

public interface Packing {
	public String pack();
	public int price();
}

public abstract class CD implements Packing {
	public abstract String pack();
}

public abstract class Company extends CD {
	public abstract int price();
}

public class Sony extends Company {
	public int price() {
		return 20;
	}
	public String pack() {
		return *Sony CD*;
	}
}

public class Samsung extends Company {
	public int price() {
		return 15;
	}
	public String pack() {
		return *Samsung CD*;
	}
}

public class CDType {
	private List<Packing> items = new ArrayList<Packing>();
	public void addItem(Packing packs) {
		items.add(packs);
	}
	public void getCost() {
		for(Packing packs : items) {
			packs.price();
		}
		public void showItems() {
			for(Packing packing : items) {
				System.out.print("CD name : "+packing.pack());
				System.out.print(", Price : "+packing.price());
			}
		}
	}
}

 public class CDBuilder {
	 public CDType buildSonyCD() {
		 CDType cds = new CDType();
		 cds.addItem(new Sony());
		 return cds;
	 }
	 public CDType buildSamsungCD() {
		 CDType cds = new CDType();
		 cdds.addItem(new Samsung());
		 return cds;
	 }
 }
 
 public class BuilderDemo {
	 public static void main(String args[]) {
		 CDBuilder cdBuilder = new CDBuilder();
		 CDType cdType1 = cdBuilder.buildSonyCD();
		 cdType1.showItems();
		 CDType cdType2 = cdBuilder.buildSamsungCD();
		 cdType2.showItems();
	 }
 }