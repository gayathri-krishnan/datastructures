package com.datastructures.assignment.week1;

import org.junit.Test;

import junit.framework.Assert;

public class CheckBracketsTest {
	private static final String SUCCESS = "Success";
	CheckBrackets cb = new CheckBrackets();
	@Test
	public void testMatch() {
		String in = "{[]}()";
		Assert.assertEquals(SUCCESS, cb.isBalanced(in));
	}
	
	@Test
	public void testMisMatch() {
		String in = "{";
		Assert.assertEquals("1", cb.isBalanced(in));
	}
	
	@Test
	public void testMatchExpression() {
		String in = "foo(bar);";
		Assert.assertEquals(SUCCESS, cb.isBalanced(in));
	}
	
	@Test
	public void testMisMatchExpression() {
		String in = "foo(bar[i);";
		Assert.assertEquals("10", cb.isBalanced(in));
	}
}
