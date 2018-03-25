package basket;

public class Main {
	
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		
		StockItem temp = new StockItem("bread", 0.80, 20);
		stockList.addStock(temp);
		
		temp = new StockItem("KitKat bar", 0.50, 22);
		stockList.addStock(temp);
		
		temp = new StockItem("cake", 1.50, 10);
		stockList.addStock(temp);
		
		temp = new StockItem("milk", 0.60, 15);
		stockList.addStock(temp);
		
		temp = new StockItem("milk", 0.50, 6);
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
		
		for(String s : stockList.Items().keySet()){
			System.out.println(s);
		}
		
		Basket basket = new Basket("Basket1");
		sellItem(basket, "milk", 10);
		sellItem(basket, "milk", 1);
		sellItem(basket, "milk", 10);
		sellItem(basket, "nonExistent", 1);
		
		System.out.println(basket.toString());
		
		sellItem(basket, "Mars bar", 10);
		sellItem(basket, "coffee", 6);
		sellItem(basket, "juice", 9);
		
		System.out.println(basket.toString());
		System.out.println(stockList.toString());
	}
	
	public static int sellItem(Basket basket, String item, int quantity){
		StockItem stockItem = stockList.get(item);
		if(stockItem == null){
			System.out.println(item + " : item unavailable");
			return 0;
		}
		if(stockList.sellStock(item, quantity) != 0){
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		return 0;
	}

}
