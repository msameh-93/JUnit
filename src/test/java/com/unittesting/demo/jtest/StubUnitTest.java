package com.unittesting.demo.jtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.unittesting.demo.business.Business;
import com.unittesting.demo.business.DataService;

class DataServiceStub implements DataService {

	@Override
	public int[] getData() {
		return new int[] {1,2,3};
	}

}
class StubUnitTest {

	@Test
	void calc_sum_basic() {
		Business business= new Business();
		business.setDataService(new DataServiceStub());
		
		int actualResult= business.calcSumDataService();
		int expectedResult= 6;
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
	
//	@Test
//	void calc_sum_empty() {
//		Business business= new Business();
//		business.setDataService(new DataServiceStub());
//		
//		int actualResult= business.calcSumDataService();
//		int expectedResult= 0;
//		
//		assertThat(actualResult).isEqualTo(expectedResult);
//		
//	}
//	
//	@Test
//	void calc_sum_oneValue() {
//		Business business= new Business();
//		business.setDataService(new DataServiceStub());
//		
//		int actualResult= business.calcSumDataService();
//		int expectedResult= 1;
//		
//		assertThat(actualResult).isEqualTo(expectedResult);
//		
//	}
}
