package in.rak.test.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import in.rak.com.Cart;
import in.rak.com.OrderManager;
import in.rak.com.ShippingAddress;

@ExtendWith(MockitoExtension.class)
public class OrderManagerTest {
	@Spy
	private Cart cart;
	
	@InjectMocks
	private OrderManager orderManager;
	
	@Test
	public void testCheckOut() {
		Map<String,Integer> products=new HashMap<>();
		products.put("p1", 1);
		products.put("p2", 29);
		
		ShippingAddress shippingAddress=new ShippingAddress();
		shippingAddress.setAddressLine1("address");
		shippingAddress.setCity("hyd");
		shippingAddress.setState("TS");
		shippingAddress.setCountry("India");
		shippingAddress.setZip(12);

		String expectOrderNo="CO"+LocalDate.now()+"Q"+products.size()+"Z " + shippingAddress.getZip();
		
	when(cart.addLineItem(eq("p1"), eq(1), anyDouble())).thenReturn("r1");
	when(cart.addLineItem(eq("p2"), eq(2), anyDouble())).thenReturn("r2");
	
	       String actualOrderNo=orderManager.checkOut(products, shippingAddress);
	       
	       verify(cart,atLeast(1)).addLineItem(eq("p1"), eq(1), anyDouble());
	       verify(cart,atLeast(1)).addLineItem(eq("p2"), eq(29), anyDouble());
	       
	       assertEquals(expectOrderNo, actualOrderNo);
	
	}

	private double anyDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int eq(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private String eq(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
