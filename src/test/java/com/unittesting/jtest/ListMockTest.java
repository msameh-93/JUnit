package com.unittesting.jtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {
	List<String> mockList= mock(List.class);

	@Test
	void sizeBasic() {
		when(mockList.size()).thenReturn(5);
		
		assertThat(mockList.size()).isEqualTo(5);
	}
	@Test
	void returnDifferentValue() {
		when(mockList.size()).thenReturn(5).thenReturn(10);
		
		assertThat(mockList.size()).isEqualTo(5);
		assertThat(mockList.size()).isEqualTo(10);

	}
	@Test
	void paramaters() {
		when(mockList.get(0)).thenReturn("Hello");
		
		assertThat(mockList.get(0)).isEqualTo("Hello");
	}
	@Test
	void argumentMatchers() {
		when(mockList.get(anyInt())).thenReturn("Hello");
		
		assertThat(mockList.get(0)).isEqualTo("Hello");
		assertThat(mockList.get(1)).isEqualTo("Hello");
		assertThat(mockList.get(2)).isEqualTo("Hello");
	}
	@Test
	void methodCallVerification() {
		mockList.get(0);
		mockList.get(1);
		
		//verifies method gets called
		verify(mockList).get(anyInt());
		verify(mockList, times(2)).get(anyInt()); //if called 1 time - DEFAULT is 1
		verify(mockList, atLeast(1)/*atLeastOnce()*/).get(anyInt()); 
		verify(mockList, atMost(2)).get(anyInt()); 
		verify(mockList, never()).get(2); 		//never gets called with value 2


	}
	@Test
	void captureArgument() {
		mockList.add("Hello");
		
		//capture object that captures the argument
		ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
	
		verify(mockList).add(captor.capture());
		
		assertThat("Hello").isEqualTo(captor.getValue());
	}
}
