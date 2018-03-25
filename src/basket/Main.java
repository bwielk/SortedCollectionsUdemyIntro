package basket;

public class Main {
	
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		
		StockItem temp = new StockItem("bread", 0.80, 20);
		stockList.addStock(temp);
		
		temp = new StockItem("cake", 1.50, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("milk", 0.60, 15);
		stockList.addStock(temp);
		
		temp = new StockItem("Mars bar", 0.50, 30);
		stockList.addStock(temp);
		
		temp = new StockItem("MilkyWay bar", 0.50, 25);
		stockList.addStock(temp);
		
		temp = new StockItem("Snickers bar", 0.50, 13);
		stockList.addStock(temp);
		
		temp = new StockItem("juice", 2.00, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("coffee", 2.50, 16);
		stockList.addStock(temp);
		
		System.out.println(stockList.toString());
	}

}
