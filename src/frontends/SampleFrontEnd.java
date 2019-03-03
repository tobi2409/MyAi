package frontends;

import logic.AiLogic;
import inspection.InspectionEntry;
import inspection.InspectionList;
import analyzemap.AnalyzeMap;
import constants.Constants;

public class SampleFrontEnd {

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
