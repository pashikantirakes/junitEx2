package in.rak.com;

import java.time.LocalDate;
import java.util.Map;

public class OrderManager {
private Cart cart;
	
	public OrderManager(Cart cart) {
		this.cart=cart;
	}
	public String checkOut(Map<String,Integer>products,ShippingAddress shippingAddress) {
		String orderNo=null;
		
		products.forEach((productCode,quantity)->{
			double unitPrice=productCode.length() * quantity;
			cart.addLineItem(productCode, quantity, unitPrice);
		});
		cart.setShippingAddress(shippingAddress);
		orderNo="CO"+LocalDate.now() + " Q" +products.size()+ "Z " + shippingAddress.getZip();
		return orderNo;
	}
}
