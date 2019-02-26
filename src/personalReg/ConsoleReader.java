package personalReg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsoleReader.
 */
public class ConsoleReader {

	/**
	 * In str.
	 *
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String inStr() throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}

	/**
	 * In int.
	 *
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public int inInt() throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		while (!str.matches("[0-9]+")) {
			System.out.println("Not a valid number ");
			str = br.readLine();
		}
		return Integer.parseInt(str);
	}

	/**
	 * In long.
	 *
	 * @return the long
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public long inLong() throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		while (!str.matches("[0-9]+")) {
			System.out.println("Not a valid number ");
			str = br.readLine();
		}
		return Long.parseLong(str);
	}

}
