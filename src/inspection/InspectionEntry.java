package inspection;

public class InspectionEntry {
	
	private int option;
	private int index;
	private Boolean oldValue;
	private Boolean inspection;
	private InspectionEntry parent;
	private InspectionList childs = new InspectionList();
	
	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Boolean getOldValue() {
		return oldValue;
	}

	public void setOldValue(Boolean oldValue) {
		this.oldValue = oldValue;
	}

	public Boolean getInspection() {
		return inspection;
	}

	public void setInspection(Boolean inspection) {
		this.inspection = inspection;
	}

	public InspectionEntry getParent() {
		return parent;
	}

	public void setParent(InspectionEntry parent) {
		this.parent = parent;
	}
	
	public InspectionList getChilds() {
		return childs;
	}
	
	/*public static InspectionEntry createInspection_ByHighestOccurence
		(int option, int index, Boolean oldValue, Boolean inspection_ByHighestOccurence, InspectionEntry parent) {
		
		return createInspection
				(option, index, oldValue, inspection_ByHighestOccurence, new InspectionList(), parent);
	}*/
	
	public static InspectionEntry createInspection
		(int option, int index, Boolean oldValue, Boolean inspection, InspectionList childs, InspectionEntry parent) {
		
		InspectionEntry result = new InspectionEntry();
		result.setOption(option);
		result.setIndex(index);
		result.setOldValue(oldValue);
		result.setInspection(inspection);
		if (childs != null) {
			result.childs.addAll(childs);
		}
		result.setParent(parent);
		return result;
	}
	
}
