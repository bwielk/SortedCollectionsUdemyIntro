package basket;

import java.util.*;

public class StockList {
	
	private final Map<String, StockItem> list;
	
	public StockList(){
		this.list = new HashMap<>();
	}
	
	public int addStock(StockItem item){
		if(item != null){
			//check if it has the quantity of the item
			StockItem inStock = list.getOrDefault(item.getName(), item);
			//adjust the quantity if there are already stocks of this item
			if(inStock != item){
				item.adjustStock(inStock.getQuantityStock());
			}
			list.put(item.getName(), item);
			return item.getQuantityStock();
		}
		return 0;
	}
	
	public int sellStock(String item, int quantity){
		StockItem inStock = list.getOrDefault(item, null);
		if((inStock != null) && (inStock.getQuantityStock() >= quantity) && quantity > 0){
			inStock.adjustStock(-quantity);
			return quantity;
		}
		return 0;
	}
}
