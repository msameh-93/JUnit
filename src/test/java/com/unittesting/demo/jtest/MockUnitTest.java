package com.unittesting.demo.jtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unittesting.demo.business.Business;
import com.unittesting.demo.business.DataService;

@ExtendWith(MockitoExtension.class)
class MockUnitTest {
	@Mock	//no need for @BeforeEach Setter
	DataService dataServiceMock= mock(DataService.class);
	
	@InjectMocks
	Business business= new Business();

//	@BeforeEach
//	public void beforeEachTest() {
//		business.setDataService(dataServiceMock);		
//	}
	
	@Test
	void calc_sum_basic() {
		when(dataServiceMock.getData()).thenReturn(new int[] {1,2,3});
		
		int actualResult= business.calcSumDataService();
		int expectedResult= 6;
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	@Test
	void calc_sum_empty() {
		when(dataServiceMock.getData()).thenReturn(new int[] {});
		
		int actualResult= business.calcSumDataService();
		int expectedResult= 0;
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	@Test
	void calc_sum_oneValue() {
		when(dataServiceMock.getData()).thenReturn(new int[] {1});
		
		int actualResult= business.calcSumDataService();
		int expectedResult= 1;
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
