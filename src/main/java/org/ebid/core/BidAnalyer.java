package org.ebid.core;

public class BidAnalyer {
	private BidSorter bidSorter;
	
	public BidAnalyer(BidSorter bidSorter) {
		this.bidSorter=bidSorter;
	}
	public double[] getTopBids(double[] bids,int n) {
		double[] sortedBids=null;
		double[] topBids=null;
		sortedBids=bidSorter.sortBids(bids);
		topBids=new double[n];
		for(int i=0;i<n;i++) {
			topBids[i]=sortedBids[i];
		}
		return topBids;
	}

}
