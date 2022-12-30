package com.ebid.core;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.ebid.core.ArrayHelper;
import org.ebid.core.Finder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ebid.core.exception.EmptyArrayException;

@ExtendWith(MockitoExtension.class)
public class ArrayHelperTest {
	@Mock
	Finder finder;

	@InjectMocks
	ArrayHelper arryHelper;
	
//	@BeforeEach
//	public void before() {
//		finder=Mockito.mock(Finder.class);
//		arryHelper=new ArrayHelper(finder);
//	}
	@Test
	public void testSumOfEvens() {
		int[] inArray=new int[] {10,5,4,1,6};
		int expectSum=26;
		
		when(finder.isEven(10)).thenReturn(true);
		when(finder.isEven(5)).thenReturn(false);
		when(finder.isEven(4)).thenReturn(true);
		when(finder.isEven(1)).thenReturn(false);
		when(finder.isEven(6)).thenReturn(true);
		
		long actualSum=arryHelper.sumOfEvenNumbers(inArray);
		assertEquals(expectSum, actualSum);
	}
	@Test
	public void testSumofEvenWithEmptyArray() {
		int[] inArray= new int[] {};
		int expectedSum=0;
		long actualSum=arryHelper.sumOfEvenNumbers(inArray);
		assertEquals(expectedSum, actualSum);
	}
	@Test
	public void testSumofEvenWithNullArray() {
		int[] inArray=null;
		int expectedSum=0;
		long actualSum=arryHelper.sumOfEvenNumbers(inArray);
		assertEquals(expectedSum, actualSum);
		Exception e=assertThrows(EmptyArrayException.class, ()->{
			arryHelper.sumOfEvenNumbers(null);
		});
		
		assertEquals("input array is null " ,e.getMessage());
	}
}
