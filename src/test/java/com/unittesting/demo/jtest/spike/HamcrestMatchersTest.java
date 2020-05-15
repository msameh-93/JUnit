package com.unittesting.demo.jtest.spike;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.emptyString;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers= Arrays.asList(12,15,45);
		
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,15));
		assertThat(numbers, everyItem(greaterThan(10)));
		
		assertThat("", is(emptyString()));
		assertThat("ABCDEF", containsString("ABC"));
		assertThat("ABCDEF", startsWith("ABC"));
		assertThat("ABCDEF", endsWith("DEF"));
	}

}
