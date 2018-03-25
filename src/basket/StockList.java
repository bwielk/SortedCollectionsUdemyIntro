package basket;

import java.util.*;

public class StockList {
	
	private final Map<String, StockItem> list;
	
	public StockList(){
		this.list = new LinkedHashMap<>();
	}
	
	public int addStock(StockItem item){
		if(item != null){
			//check if it has the quantity of the item
			StockItem inStock = list.getOrDefault(item.getName(), item);
			//adjust the quantity if there are already stocks of this item
			if(inStock != item){
				item.adjustStock(inStock.quantityInStock());
			}
			list.put(item.getName(), item);
			return item.quantityInStock();
		}
		return 0;
	}
	
	public int sellStock(String item, int quantity){
		StockItem inStock = list.getOrDefault(item, null);
		if((inStock != null) && (inStock.quantityInStock() >= quantity) && quantity > 0){
			inStock.adjustStock(-quantity);
			return quantity;
		}
		return 0;
	}
	
	public StockItem get(String key){
		return list.get(key);
	}
	
	public Map<String, StockItem> Items(){
		return Collections.unmodifiableMap(list);
	}
	
	@Override
	public String toString(){
		String s = "\nStockList\n";
		double totalCost = 0.0;
		for(Map.Entry<String, StockItem> item : list.entrySet()){
			StockItem stockItem = item.getValue();
			
			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
			s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
			s = s + String.format("%.2f", itemValue) + "\n";
			totalCost += itemValue;
		}
		return s + " Total Stock Value " + String.format("%.2f",totalCost);
	}
}
