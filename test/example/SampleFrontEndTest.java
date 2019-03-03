package example;

import org.junit.Assert;
import org.junit.Test;

import testfactory.Factory;
import testwrapper.Wrapper;
import inspection.InspectionList;
import frontends.SampleFrontEnd;

public class SampleFrontEndTest {

  /*@Test
  public void testRun() {
    boolean[] vector = Factory.createVector(10);

    InspectionList result = SampleFrontEnd.run(vector, new int[] {0, 2}, new int[] {1}, new int[] {1, 2});
    Assert.assertEquals(result.size(), 6);
    Wrapper.testInspectionEntry(result.get(0), 0, 1, true, true, null);
    Assert.assertEquals(result.get(0).getChilds().size(), 2);
    Wrapper.testInspectionEntry(result.get(0).getChilds().get(0), 0, 1, true, false, result.get(0));
    Wrapper.testInspectionEntry(result.get(0).getChilds().get(1), 0, 2, true, false, result.get(0));

    Wrapper.testInspectionEntry(result.get(1), 0, 2, true, false, null);
    Assert.assertEquals(result.get(1).getChilds().size(), 2);
    Wrapper.testInspectionEntry(result.get(1).getChilds().get(0), 0, 1, false, false, result.get(1));
    Wrapper.testInspectionEntry(result.get(1).getChilds().get(1), 0, 2, false, true, result.get(1));

    Wrapper.testInspectionEntry(result.get(2), 2, 1, false, false, null);
    Assert.assertEquals(result.get(2).getChilds().size(), 2);
    Wrapper.testInspectionEntry(result.get(2).getChilds().get(0), 2, 1, false, false, result.get(2));
    Wrapper.testInspectionEntry(result.get(2).getChilds().get(1), 2, 2, false, true, result.get(2));

    Wrapper.testInspectionEntry(result.get(3), 2, 2, false, true, null);
    Assert.assertEquals(result.get(3).getChilds().size(), 2);
    Wrapper.testInspectionEntry(result.get(3).getChilds().get(0), 2, 1, true, false, result.get(3));
    Wrapper.testInspectionEntry(result.get(3).getChilds().get(1), 2, 2, true, false, result.get(3));

    Wrapper.testInspectionEntry(result.get(4), 1, 1, true, false, null);
    Assert.assertEquals(result.get(4).getChilds().size(), 0);

    Wrapper.testInspectionEntry(result.get(5), 1, 2, true, false, null);
    Assert.assertEquals(result.get(5).getChilds().size(), 0);
  }*/

}
