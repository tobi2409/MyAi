package analyzemap;

import java.util.HashMap;

public class AnalyzeMap extends HashMap<Object, Integer> {

	public Integer put(Object key) {
		Integer occurence = get(key) == null
				? 1 : get(key) + 1;
		return put(key, occurence);
	}

	public void putAll(AnalyzeMap analyzeMap) {
		for (Object entry : analyzeMap.keySet()) {
			put(entry);
		}
	}

}
