/**
 *
 * MyAi - Logic
 * by Tobias Hollstein 02-14-2019
 *
 */

package logic;

import java.util.List;
import java.util.Map.Entry;

import analyzemap.AnalyzeMap;
import inspection.InspectionEntry;
import inspection.InspectionList;

import constants.Constants;

public class AiLogic {

	/**
	 *
	 * With the help of our world (vector) we try out some options and notice the new vector after an option was taken
	 *
	 * @param vector
	 * world (vector) to inspect with VectorLogic
	 *
	 * @param index
	 * because nobody can see all the world and all the elements of the world after it was changed,
	 * you have to set up which element of the world you want to consider accurate
	 *
	 * @param optionsToTest
	 * which options VectorLogic should test to change the world?
	 *
	 * @param times
	 * after the world was changed how many other times the world should be changed
	 * times = 1 : change world 1 time
	 * times = 2 : change world 1 time after it was already changed
	 *
	 * @return
	 * List of InspectionEntries.
	 *
	 */

	public static InspectionList inspect(Object[] vector, int index, int[] optionsToTest, int times) {
		return inspect(vector, index, optionsToTest, times, null);
	}

	private static InspectionList inspect(Object[] vector, int index, int[] optionsToTest, int times, InspectionEntry parent) {
		InspectionList result = new InspectionList();

		if (times == 0) {
			return result;
		}

		for (int optionEntry : optionsToTest) {
			Object[] nextState = SampleVectorLogic.runTime(vector, optionEntry);
			Object indexOfNextState = nextState[index];

			InspectionEntry inspectionEntry =
					InspectionEntry.createInspection(optionEntry, index, vector[index], indexOfNextState, null, parent);
			InspectionList rec = inspect(nextState, index, optionsToTest, times - 1, inspectionEntry);
			inspectionEntry.getChilds().addAll(rec);

			result.add(inspectionEntry);
		}

		return result;
	}

	/**
	 *
	 * Which new Value was the most common of the InspectionList for a comparable old Value and a comparableProperty (e.g. Option)?
	 * It's necessary to get the probability of which new Value you can get by an old Value and an property to analyze.
	 * If the compareProperty is an Option you get a Map of the probabilities of a new Value by the selected Option
	 *
	 * If analyzeMap only contains 1 Entry, the valueToCompare in combination with the compareProperty (e.g. option) is universally applicable
	 * That means: If by taking valueToCompare = true and compareProperty (option) = 1 it analyzes every time the same new Value, it's universally applicable
	 *
	 * @param oldInspections
	 * all previous inspections
	 *
	 * @param valueToCompare
	 * it compares this value with oldValue from an InspectionEntry.
	 *
	 * @param compareProperty
	 * the property you want to analyze
	 * Constants.OPTION = OPTION
	 * Constants.INDEX = INDEX
	 *
	 * @param comparePropertyValue
	 * it compares this value with the selected Property in compareProperty from an InspectionEntry
	 *
	 * @return
	 * AnalyzeMap = Map<newValue = Boolean, how many times? = Integer>
	 *
	 */

	public static AnalyzeMap analyze(InspectionList oldInspections, Object valueToCompare,
	 					String compareProperty, int comparePropertyValue) {
		AnalyzeMap result = new AnalyzeMap();

		for (InspectionEntry inspectionEntry : oldInspections) {
			Object valueOfEntry = inspectionEntry.getOldValue();

			int propertyValueOfEntry = 0;
			switch (compareProperty) {
				case Constants.OPTION:
					propertyValueOfEntry = inspectionEntry.getOption();
					break;
				case Constants.INDEX:
					propertyValueOfEntry = inspectionEntry.getIndex();
					break;
			}

			if (valueOfEntry == valueToCompare && propertyValueOfEntry == comparePropertyValue) {
				Object inspected = inspectionEntry.getInspection();
				result.put(inspected);
			}

			AnalyzeMap rec = analyze(inspectionEntry.getChilds(), valueToCompare, compareProperty, comparePropertyValue);
			result.putAll(rec);
		}

		return result;
	}

	/**
	 *
	 * Do the same job as analyze. But do it more precisely by analyzing e.g. more options or indicies.
	 * TODO: analyzePrecise by multiple compareProperties
	 *
	 * @param oldInspections
	 * all previous inspections
	 *
	 * @param valueToCompare
	 * it compares this value with oldValue from an InspectionEntry.
	 *
	 * @param analyzeStart
	 * first option or index you want to analyze
	 * (e.g. option = 1)
	 *
	 * @param analyzeEnd
	 * last option or index you want to analyze
	 * (e.g. option = 3)
	 *
	 * @param compareProperty
	 * the property you want to analyze
	 * Constants.OPTION = OPTION
	 * Constants.INDEX = INDEX
	 *
	 * @return
	 * AnalyzeMap = Map<newValue = Boolean, how many times? = Integer>
	 *
	 */

	public static AnalyzeMap analyzePrecise(InspectionList oldInspections, Object valueToCompare,
							int analyzeStart, int analyzeEnd, String compareProperty) {
		AnalyzeMap result = new AnalyzeMap();

		for (int i = analyzeStart ; i <= analyzeEnd ; i++) {
			AnalyzeMap analyzeMap = analyze(oldInspections, valueToCompare, compareProperty, i);
			result.putAll(analyzeMap);
		}

		return result;
	}

	/**
	 * gets Key from AnalyzeMap by it's highest Value
	 *
	 * @param analyzeMap
	 * @return Key by it's highest Value
	 */

	public static Object getByHighestOccurence(AnalyzeMap analyzeMap) {
		Object keyByHighestOccurence = null;

		for (Entry<Object, Integer> entry : analyzeMap.entrySet()) {
			Object key = entry.getKey();
			Integer value = entry.getValue();

			if (keyByHighestOccurence == null || value > analyzeMap.get(keyByHighestOccurence)) {
				keyByHighestOccurence = key;
			}
		}

		return keyByHighestOccurence;
	}

	/**
	 *
	 * @param oldInspections
	 * all previous inspections
	 *
	 * @param goalValue
	 * new value as goal
	 *
	 * @param extraQuery
	 * if you want to set up an index or another parameter which are relevant for searching the goal
	 *
	 * @return
	 * InspectionList in dependency of oldInspections
	 * only that Inspections are listed where the goal is accomplished
	 *
	 */

	public static InspectionList traceGoal(InspectionList oldInspections, Object goalValue, boolean extraQuery) {
		InspectionList result = new InspectionList();

		for (InspectionEntry inspectionEntry : oldInspections) {
			InspectionEntry newInspectionEntry = InspectionEntry.createInspection
					(inspectionEntry.getOption(), inspectionEntry.getIndex(), inspectionEntry.getOldValue(),
							inspectionEntry.getInspection(), new InspectionList(), inspectionEntry.getParent());

			if (inspectionEntry.getInspection() == goalValue && extraQuery) {
				result.add(newInspectionEntry);
			}

			if (inspectionEntry.getChilds().size() > 0) {
				List<InspectionEntry> rec = traceGoal(inspectionEntry.getChilds(), goalValue, extraQuery);
				result.addAll(rec);
			}
		}

		return result;
	}

}
