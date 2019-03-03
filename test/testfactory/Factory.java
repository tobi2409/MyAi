package testfactory;

import inspection.InspectionEntry;
import inspection.InspectionList;

public class Factory {

	public static Object[] createVector(int length) {
		Object[] vector = new Object[length];

		for (int i = 0 ; i < vector.length ; i++) {
			Boolean isFalse = i >= 2 && (Boolean) vector[i - 1] == true && (Boolean) vector[i - 2] == true;
			Boolean isTrue = !isFalse;
			vector[i] = isTrue;
		}

		return vector;
	}

	public static InspectionList createInspectionList() {
		InspectionList result = new InspectionList();

		InspectionEntry entry0 = new InspectionEntry();
		entry0.setIndex(0);
		entry0.setOption(1);
		entry0.setOldValue(true);
		entry0.setInspection(true);
		entry0.setParent(null);
		result.add(entry0);

		InspectionEntry entry0_0 = new InspectionEntry();
		entry0_0.setIndex(0);
		entry0_0.setOption(1);
		entry0_0.setOldValue(true);
		entry0_0.setInspection(false);
		entry0_0.setParent(entry0);
		entry0.getChilds().add(entry0_0);

		InspectionEntry entry0_1 = new InspectionEntry();
		entry0_1.setIndex(0);
		entry0_1.setOption(2);
		entry0_1.setOldValue(true);
		entry0_1.setInspection(false);
		entry0_1.setParent(entry0);
		entry0.getChilds().add(entry0_1);

		InspectionEntry entry1 = new InspectionEntry();
		entry1.setIndex(0);
		entry1.setOption(2);
		entry1.setOldValue(true);
		entry1.setInspection(false);
		entry1.setParent(null);
		result.add(entry1);

		InspectionEntry entry1_0 = new InspectionEntry();
		entry1_0.setIndex(0);
		entry1_0.setOption(1);
		entry1_0.setOldValue(false);
		entry1_0.setInspection(false);
		entry1_0.setParent(entry1);
		entry1.getChilds().add(entry1_0);

		InspectionEntry entry1_1 = new InspectionEntry();
		entry1_1.setIndex(0);
		entry1_1.setOption(2);
		entry1_1.setOldValue(false);
		entry1_1.setInspection(true);
		entry1_1.setParent(entry1);
		entry1.getChilds().add(entry1_1);

		return result;
	}

}
