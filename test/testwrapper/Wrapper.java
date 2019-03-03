package testwrapper;

import org.junit.Assert;
import inspection.InspectionEntry;

public class Wrapper {

  public static void testInspectionEntry(InspectionEntry entry,
			int shouldIndex, int shouldOption, Object shouldOldValue,
			Object shouldInspection, InspectionEntry shouldParent) {

		Assert.assertEquals(entry.getIndex(), shouldIndex);
		Assert.assertEquals(entry.getOption(), shouldOption);
		Assert.assertEquals(entry.getOldValue(), shouldOldValue);
		Assert.assertEquals(entry.getInspection(), shouldInspection);
		Assert.assertEquals(entry.getParent(), shouldParent);
	}

}
