package basket;

public class StockItem implements Comparable{
	
	private final String name;
	private double price;
	private int quantityStock = 0;
	
	public StockItem(String name, double price){
		this.price = price;
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price > 0.0){
			this.price = price;
		}
	}

	public int getQuantityStock() {
		return quantityStock;
	}

	public void adjustStock(int quantityStock) {
		int newStock = this.quantityStock += quantityStock;
		if(newStock >= 0){
			this.quantityStock = newStock;
		}
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o){
		System.out.println("Starting equals()");
		if(this == o){
			return true;
		}
		if(o == null || (o.getClass() != this.getClass())){
			return false;
		}
		String objName = ((StockItem)o).getName();
		return this.name.equals(objName);
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode() + 12;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
