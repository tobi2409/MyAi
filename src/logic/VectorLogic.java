/**
 *
 * MyAi - VectorLogic
 * by Tobias Hollstein 02-14-2019
 *
 */

package logic;

public class VectorLogic {

	/**
	 * change vector by this logic (-> time increases by 1)
	 * option is similar to the options you have (eg. with help of muscles) in real world to take influence to the particles
	 **/

	public static boolean[] runTime(boolean[] vector, int option) {
		boolean[] cloned = vector.clone();

		if (option == 1) {
			return runOption1(cloned);
		} else if (option == 2) {
			return runOption2(cloned);
		} else if (option == 3) {
			return runOption3(cloned);
		}

		return cloned;
	}

	private static boolean[] runOption1(boolean[] cloned) {
		for (int i = 0 ; i < cloned.length ; i++) {
			boolean entry = cloned[i];
			boolean next = i < cloned.length - 1 && cloned[i + 1];
			if (entry && !next) {
				cloned[i] = false;
			}
		}

		return cloned;
	}

	private static boolean[] runOption2(boolean[] cloned) {
		for (int i = 0 ; i < cloned.length ; i++) {
			boolean entry = cloned[i];
			cloned[i] = !entry;
		}

		return cloned;
	}

	private static boolean[] runOption3(boolean[] cloned) {
		for (int i = 0 ; i < cloned.length ; i++) {
			cloned[i] = true;
		}

		return cloned;
	}

}
