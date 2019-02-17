package logic;

import org.junit.Test;

import testfactory.Factory;
import junit.framework.Assert;

public class VectorLogicTest {

	@Test
	public void testRunTime_Option1() {
		boolean[] vector = Factory.createVector(5);
		boolean[] updatedVector = VectorLogic.runTime(vector, 1);
		Assert.assertEquals(updatedVector.length, 5);
		Assert.assertEquals(updatedVector[0], true);
		Assert.assertEquals(updatedVector[1], false);
		Assert.assertEquals(updatedVector[2], false);
		Assert.assertEquals(updatedVector[3], true);
		Assert.assertEquals(updatedVector[4], false);
	}

	@Test
	public void testRunTime_Option2() {
		boolean[] vector = Factory.createVector(5);
		boolean[] updatedVector = VectorLogic.runTime(vector, 2);
		Assert.assertEquals(updatedVector.length, 5);
		Assert.assertEquals(updatedVector[0], false);
		Assert.assertEquals(updatedVector[1], false);
		Assert.assertEquals(updatedVector[2], true);
		Assert.assertEquals(updatedVector[3], false);
		Assert.assertEquals(updatedVector[4], false);
	}

	@Test
	public void testRunTime_Option3() {
		boolean[] vector = Factory.createVector(5);
		boolean[] updatedVector = VectorLogic.runTime(vector, 3);
		Assert.assertEquals(updatedVector.length, 5);
		Assert.assertEquals(updatedVector[0], true);
		Assert.assertEquals(updatedVector[1], true);
		Assert.assertEquals(updatedVector[2], true);
		Assert.assertEquals(updatedVector[3], true);
		Assert.assertEquals(updatedVector[4], true);
	}

}
