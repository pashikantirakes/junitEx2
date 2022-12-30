package org.ebid.core;

import com.ebid.core.exception.EmptyArrayException;

public class BidSorterImpl implements BidSorter {

	@Override
	public double[] sortBids(double[] bids) {
        double[] sortedBids=null;
        double temp=0.0;
        
        if(bids==null || bids.length==0) {
        	throw new EmptyArrayException("Bids are empty");
        }
        sortedBids=new double[bids.length];
        for(int i=0;i<bids.length;i++) {
        	sortedBids[i]=bids[i];
        }
        for(int i=0;i<bids.length-1;i++)
        {
        	for(int j=0;j<bids.length-1;j++) {
        		if(sortedBids[j]<sortedBids[j+1]) {
        			temp=sortedBids[j];
        			sortedBids[j]=sortedBids[j+1];
        			sortedBids[j+1]=temp;
        		}
        	}
        }
		return sortedBids;
	}

}
