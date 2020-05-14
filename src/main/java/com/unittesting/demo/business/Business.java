package com.unittesting.demo.business;

public class Business {
	private DataService dataService;
	
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	public int calcSum(int[] arr) {
		int result= 0;
		for(int num : arr ) {
			result += num;
		}
		return result;
	}
	public int calcSumDataService() {
		int result= 0;
		for(int num : dataService.getData() ) {
			result += num;
		}
		return result;
	}
}
