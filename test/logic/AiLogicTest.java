package logic;

import org.junit.Assert;
import org.junit.Test;

import testfactory.Factory;
import testwrapper.Wrapper;
import analyzemap.AnalyzeMap;
import inspection.InspectionEntry;
import inspection.InspectionList;
import logic.AiLogic;

import constants.Constants;

public class AiLogicTest {

	@Test
	public void testInspect() {
		Object[] vector = Factory.createVector(10);
		InspectionList result = AiLogic.inspect(vector, 0, new int[] {1, 2}, 2);

		Assert.assertEquals(result.size(), 2);

		InspectionEntry entry0 = result.get(0);
		Wrapper.testInspectionEntry(entry0, 0, 1, true, true, null);

		Assert.assertEquals(entry0.getChilds().size(), 2);
		InspectionEntry entry0_0 = entry0.getChilds().get(0);
		Wrapper.testInspectionEntry(entry0_0, 0, 1, true, false, entry0);
		Assert.assertEquals(entry0_0.getChilds().size(), 0);

		InspectionEntry entry0_1 = entry0.getChilds().get(1);
		Wrapper.testInspectionEntry(entry0_1, 0, 2, true, false, entry0);
		Assert.assertEquals(entry0_1.getChilds().size(), 0);

		InspectionEntry entry1 = result.get(1);
		Wrapper.testInspectionEntry(entry1, 0, 2, true, false, null);

		Assert.assertEquals(entry1.getChilds().size(), 2);
		InspectionEntry entry1_0 = entry1.getChilds().get(0);
		Wrapper.testInspectionEntry(entry1_0, 0, 1, false, false, entry1);
		Assert.assertEquals(entry1_0.getChilds().size(), 0);

		InspectionEntry entry1_1 = entry1.getChilds().get(1);
		Wrapper.testInspectionEntry(entry1_1, 0, 2, false, true, entry1);
		Assert.assertEquals(entry1_1.getChilds().size(), 0);
	}

	@Test
	public void testAnalyze() {
		InspectionList oldInspections = Factory.createInspectionList();
		AnalyzeMap result = AiLogic.analyze(oldInspections, true, Constants.OPTION, 1);

		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals((int) result.get(true), 1);
		Assert.assertEquals((int) result.get(false), 1);
	}

	@Test
	public void testAnalyzePrecise() {
		InspectionList oldInspections = Factory.createInspectionList();
		AnalyzeMap result = AiLogic.analyzePrecise(oldInspections, true, 1, 3, Constants.OPTION);

		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals((int) result.get(true), 1);
		Assert.assertEquals((int) result.get(false), 2);
	}

	@Test
	public void testGetByHighestOccurence() {
		AnalyzeMap analyzeMap = new AnalyzeMap();
		analyzeMap.put(true, 5);
		analyzeMap.put(false, 2);

		Object result = AiLogic.getByHighestOccurence(analyzeMap);
		Assert.assertEquals(result, true);
	}

	@Test
	public void testTraceGoal() {
		InspectionList oldInspections = Factory.createInspectionList();

		InspectionList result = AiLogic.traceGoal(oldInspections, true, true);

		Assert.assertEquals(result.size(), 2);

		Wrapper.testInspectionEntry(result.get(0), 0, 1, true, true, null);
		Assert.assertEquals(result.get(0).getChilds().size(), 0);

		Wrapper.testInspectionEntry(result.get(1), 0, 2, false, true, oldInspections.get(1));
		Assert.assertEquals(result.get(1).getChilds().size(), 0);
	}

}
