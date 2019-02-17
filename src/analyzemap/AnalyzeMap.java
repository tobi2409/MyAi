package analyzemap;

import java.util.HashMap;

public class AnalyzeMap extends HashMap<Boolean, Integer> {

	public Integer put(Boolean key) {
		Integer occurence = get(key) == null
				? 1 : get(key) + 1;
		return put(key, occurence);
	}

	public void putAll(AnalyzeMap analyzeMap) {
		for (Boolean entry : analyzeMap.keySet()) {
			put(entry);
		}
	}

}
