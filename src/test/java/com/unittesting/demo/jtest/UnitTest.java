package com.unittesting.demo.jtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.unittesting.demo.business.Business;

class UnitTest {
	
	@Test
	void calc_sum_basic() {
		Business business= new Business();
		
		int actualResult= business.calcSum(new int[] {1,2,3});
		int expectedResult= 6;
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
	
	@Test
	void calc_sum_empty() {
		Business business= new Business();
		
		int actualResult= business.calcSum(new int[] {});
		int expectedResult= 0;
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
	
	@Test
	void calc_sum_oneValue() {
		Business business= new Business();
		
		int actualResult= business.calcSum(new int[] {1});
		int expectedResult= 1;
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
}
