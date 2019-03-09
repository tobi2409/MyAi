package example;

import logic.AiLogic;
import inspection.InspectionEntry;
import inspection.InspectionList;
import analyzemap.AnalyzeMap;
import constants.Constants;

public class SampleFrontEnd {

	private SampleVectorLogic sampleVectorLogic = new SampleVectorLogic();
	private InspectionList allInspections = new InspectionList();

  /**
	 *
	 * Example Function to combine all Modules of MyAi
   * TODO: must be improved!!
	 *
	 * @param vector
	 *
	 *
	 * @param easyIndex
	 * @param analyzeIndex
	 * @param options
	 * @return
	 */

	 //1.) sample-vector
	 //2.) inspect vector (Test-Phase)
	 //3.) define goal
	 //4.) trace goal and meanwhile analyze vector with the traced oldValue until goal has highest probability

	public InspectionEntry run(Object[] vector, int index, int[] options, int times, Object goal) {
		allInspections.addAll(AiLogic.inspect(sampleVectorLogic, vector, index, options, times));
		InspectionList filteredByGoals = AiLogic.traceGoal(allInspections, goal, true);

		for (InspectionEntry entry : filteredByGoals) {
			AnalyzeMap analyzeMap = AiLogic.analyze(allInspections, entry.getOldValue(), Constants.OPTION, entry.getOption());

			Object newValueByHighestOccurence = AiLogic.getByHighestOccurence(analyzeMap);
			if (newValueByHighestOccurence == goal) {
				return entry;
			}
		}

		return null;
	}

	/*public static InspectionList run(boolean[] vector, int[] easyIndex, int[] analyzeIndex, int[] options) {
		InspectionList inspections = new InspectionList();

		for (int element : easyIndex) {
			inspections.addAll(AiLogic.inspect(vector, element, options, 2));
		}

		for (int element : analyzeIndex) {
			for (int optionElement: options) {
				boolean oldValue = vector[element];
				AnalyzeMap analyzeMap = AiLogic.analyze(inspections, oldValue, Constants.OPTION, optionElement);
				boolean byHighestOccurence = AiLogic.getByHighestOccurence(analyzeMap);
				InspectionEntry inspectionEntry = InspectionEntry.createInspection
							(optionElement, element, oldValue, byHighestOccurence, null, null);
				inspections.add(inspectionEntry);
			}
		}

		return inspections;
	}*/

}
