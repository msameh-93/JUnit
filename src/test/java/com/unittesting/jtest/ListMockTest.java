package com.unittesting.jtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListMockTest {
	List mockList= mock(List.class);

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
	void genericParameters() {
		when(mockList.get(anyInt())).thenReturn("Hello");
		
		assertThat(mockList.get(0)).isEqualTo("Hello");
		assertThat(mockList.get(1)).isEqualTo("Hello");
		assertThat(mockList.get(2)).isEqualTo("Hello");
	}
}
