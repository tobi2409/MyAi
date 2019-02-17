package inspection;

import java.util.ArrayList;

public class InspectionList extends ArrayList<InspectionEntry> {
	
	public boolean containsInspectionByIndex(int index) {
		for (int i = 0 ; i < size() ; i++) {
			InspectionEntry element = get(i);
			
			if (element.getIndex() == index) {
				return true;
			}
		}
		
		return false;
	}
	
}
