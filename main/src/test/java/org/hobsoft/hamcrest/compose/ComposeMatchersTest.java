/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hobsoft.hamcrest.compose;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hobsoft.hamcrest.compose.ComposeMatchers.compose;
import static org.hobsoft.hamcrest.compose.ComposeMatchers.hasFeature;
import static org.hobsoft.hamcrest.compose.ComposeMatchers.hasFeatureValue;
import static org.junit.Assert.assertThat;

/**
 * Tests {@code ComposeMatchers}.
 */
public class ComposeMatchersTest
{
	// ----------------------------------------------------------------------------------------------------------------
	// tests
	// ----------------------------------------------------------------------------------------------------------------

	@Test
	public void composeReturnsMatcher()
	{
		Matcher<String> actual = compose("x", startsWith("y")).and(endsWith("z"));
		
		assertThat(actual.matches("yz"), is(true));
	}
	
	@Test
	public void composeWithoutDescriptionReturnsMatcher()
	{
		Matcher<String> actual = compose(startsWith("x")).and(endsWith("y"));
		
		assertThat(actual.matches("xy"), is(true));
	}
	
	@Test
	public void hasFeatureReturnsMatcher()
	{
		Matcher<String> actual = hasFeature("x", "y", String::length, equalTo(1));
		
		assertThat(actual.matches("z"), is(true));
	}
	
	@Test
	public void hasFeatureWithoutDescriptionReturnsMatcher()
	{
		Matcher<String> actual = hasFeature("x", String::length, equalTo(1));
		
		assertThat(actual.matches("y"), is(true));
	}

	@Test
	public void hasFeatureWithoutNameReturnsMatcher()
	{
		Matcher<String> actual = hasFeature(String::length, equalTo(1));

		assertThat(actual.matches("x"), is(true));
	}

	@Test
	public void hasFeatureValueReturnsMatcher()
	{
		Matcher<String> actual = hasFeatureValue("x", "y", String::toString, "z");

		assertThat(actual.matches("z"), is(true));
	}

	@Test
	public void hasFeatureValueWithoutDescriptionReturnsMatcher()
	{
		Matcher<String> actual = hasFeatureValue("x", String::toString, "z");

		assertThat(actual.matches("z"), is(true));
	}

	@Test
	public void hasFeatureValueWithoutNameReturnsMatcher()
	{
		Matcher<String> actual = hasFeatureValue(String::toString, "z");

		assertThat(actual.matches("z"), is(true));
	}
}
