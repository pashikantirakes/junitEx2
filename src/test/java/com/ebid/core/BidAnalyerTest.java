package com.ebid.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.ebid.core.BidAnalyer;
import org.ebid.core.BidSorter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ebid.core.exception.EmptyArrayException;

@ExtendWith(MockitoExtension.class)
public class BidAnalyerTest {
	
	@Mock
	BidSorter bidSorter;
	
	@InjectMocks
	BidAnalyer bidAnalyzer;
	
	@Test
	public void testGetTopBidsWithNullArray() {
		double[] bids=null;
		when(bidSorter.sortBids(bids)).thenThrow(EmptyArrayException.class);
		assertThrows(EmptyArrayException.class, ()->{
			bidAnalyzer.getTopBids(bids, 1);
		});
	}

	@Test
	public void getTopBids() {
		double[] bids=new double[] {12,13.1,34,78.1,34.6,45};
		int n=3;
		double[] expectedTopBids=new double[] {78.1,45,34.6};
		double[] actualBids=bidAnalyzer.getTopBids(bids, n);
		assertArrayEquals(expectedTopBids, actualBids);
	}
}
