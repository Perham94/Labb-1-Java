package personalReg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
	public String inStr() throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}

	public int inInt() throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		while (!str.matches("[0-9]+")) {
			System.out.println("Not a valid number ");
			str = br.readLine();
		}
		return Integer.parseInt(str);
	}

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
