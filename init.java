import java.util.*;
import java.io.*;

public class sorter {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// File I/O

		String text = "a b c";
		text = new Scanner(new File("source.txt")).useDelimiter("\\A").next();
		PrintWriter out = new PrintWriter("output.txt");

		String[] textA = text.split(" ");

		ArrayList<String> words = new ArrayList(); // word storage
		ArrayList<Integer> count = new ArrayList(); // num iterations

		int index = 0;// pos in textA
		// System.out.println(textA.length);
		boolean repeat = false;
		while (index < textA.length) {
			// System.out.println("running " + index + "Word At Index: " + textA[index]);

			repeat = false;
			int repeatedIndex = -1;
			// check for repeats
			for (int i = 0; i < words.size(); i++) {

				if (textA[index].equals(words.get(i))) {
					repeat = true;
					repeatedIndex = i;
				}

			}
			if (repeat) {
				// System.out.println("Repeated!");
				count.set(repeatedIndex, count.get(repeatedIndex) + 1);
				// System.out.println("failed");
			} else {
				words.add(textA[index]);
				count.add(1);
				// System.out.println("unique");
			}
			index += 1;

		}
		// hashing together arrays:
		String[][] hashedArr = new String[words.size()][2];
		String[][] finalArr = new String[words.size()][2];

		for (int i = 0; i < words.size(); i++) {
			hashedArr[i][0] = words.get(i);
			// System.out.println(words.get(i));
			hashedArr[i][1] = Integer.toString(count.get(i));
		}

		// filtratio
		/*
		 * for (int i = 0; i < words.size(); i++) { System.out.println(hashedArr[i][1]+
		 * " "+ hashedArr[i][0]); if (hashedArr[i][1].equals("1")) { hashedArr[i][0] =
		 * "kiwis"; hashedArr[i][1] = "-1"; }
		 * 
		 * }
		 */

		// sorter
		// check if sorted:
		// System.out.println("Total Indices" + words.size());
		boolean sorted = false;
		int counter = 0;
		while (!sorted) {
			sorted = true;// init at each runthrough to be true sorted
			for (int i = 0; i < words.size() - 1; i++) {// iterate thru all words
				for (int j = 0; j < words.size() - 1; j++) {// check sorted
					if (Integer.parseInt(hashedArr[i][1]) > Integer.parseInt(hashedArr[i + 1][1])) {// make unsorted
						// System.out.println("checkIndices" + i + " " + (i + 1));
						sorted = false;
						String tempVarN = hashedArr[i + 1][1];
						hashedArr[i + 1][1] = hashedArr[i][1];
						hashedArr[i][1] = tempVarN;
						String tempVarS = hashedArr[i + 1][0];
						hashedArr[i + 1][0] = hashedArr[i][0];
						hashedArr[i][0] = tempVarS;
					}
				}

			}
			System.out.println("Reset i = " + counter);
			counter++;

		}
		// reverse Direction

		for (int i = 0; i < hashedArr.length; i++) {

			finalArr[i][0] = hashedArr[hashedArr.length - i - 1][0];
			finalArr[i][1] = hashedArr[hashedArr.length - i - 1][1];
			/*
			 * finalArr[i][0] = hashedArr[i][0]; finalArr[i][1] = hashedArr[i][1];
			 */

		}

		// prettyprinting
		for (int i = 0; i < words.size(); i++) {
			int spaceLen = 40 - finalArr[i][0].length();
			if (!finalArr[i][0].equals("kiwis")) {
				out.print(finalArr[i][0]);
				// System.out.print(finalArr[i][0]);

				for (int j = 0; j < spaceLen; j++) {
					// System.out.print("-");
					out.print(" ");
				}

				// System.out.println(finalArr[i][1]);
				out.println(finalArr[i][1]);
			}
		}
		out.close();
		System.out.println("DONE");
	}
}
