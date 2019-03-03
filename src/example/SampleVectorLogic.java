/**
 *
 * MyAi -
 * by Tobias Hollstein 02-14-2019
 *
 */

package example;

import java.util.Arrays;
import logic.VectorLogic;

public class SampleVectorLogic extends VectorLogic {

	/**
	 * change vector by this logic (-> time increases by 1)
	 * option is similar to the options you have (eg. with help of muscles) in real world to take influence to the particles
	 **/

	 @Override
	public Object[] runTime(Object[] vector, int option) {
		Boolean[] cloned = Arrays.copyOf(vector, vector.length, Boolean[].class);

		if (option == 1) {
			return runOption1(cloned);
		} else if (option == 2) {
			return runOption2(cloned);
		} else if (option == 3) {
			return runOption3(cloned);
		}

		return cloned;
	}

	private Boolean[] runOption1(Boolean[] cloned) {
		for (int i = 0 ; i < cloned.length ; i++) {
			Boolean entry = cloned[i];
			Boolean next = i < cloned.length - 1 && (Boolean) cloned[i + 1];

			if (entry && !next) {
				cloned[i] = false;
			}
		}

		return cloned;
	}

	private Boolean[] runOption2(Boolean[] cloned) {
		for (int i = 0 ; i < cloned.length ; i++) {
			Boolean entry = (Boolean) cloned[i];
			cloned[i] = !entry;
		}

		return cloned;
	}

	private Boolean[] runOption3(Boolean[] cloned) {
		for (int i = 0 ; i < cloned.length ; i++) {
			cloned[i] = true;
		}

		return cloned;
	}

}
