package org.ebid.core;

import java.util.stream.IntStream;

import com.ebid.core.exception.EmptyArrayException;

public class ArrayHelper {
	private Finder finder;
	
	public ArrayHelper(Finder finder) {
		this.finder=finder;
	}
	public long sumOfEvenNumbers(int[] inArray ) {
		long sumofEven=0;
		
		if(inArray==null) {
			throw new EmptyArrayException("input array is null");
		}
	sumofEven=	IntStream.of(inArray).reduce(0,(sum,n)->{
			if(finder.isEven(n)) {
				return sum+n;
			}else {
				return sum;
			}
		});
		return sumofEven;
	}

}
