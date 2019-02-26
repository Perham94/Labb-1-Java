package personalReg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class IO.
 */
public class IO {

	/** The Constant CHARSET. */
	private final static Charset CHARSET = Charset.forName("UTF-8");

	/**
	 * Write.
	 *
	 * @param text the text
	 * @param file the file
	 */
	public static void write(String text, String file) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), CHARSET)) {
			writer.write(text, 0, text.length());
			writer.newLine();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	/**
	 * Write append.
	 *
	 * @param text the text
	 * @param file the file
	 */
	public static void writeAppend(String text, String file) {

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), CHARSET, StandardOpenOption.APPEND)) {
			writer.write(text, 0, text.length());
			writer.newLine();

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	/**
	 * Serialize.
	 *
	 * @param obj  the obj
	 * @param path the path
	 */
	public static void serialize(Object obj, String path) {
		try {
			FileOutputStream filout = new FileOutputStream(path);
			ObjectOutputStream obstr = new ObjectOutputStream(filout);
			obstr.writeObject(obj);
			obstr.close();
			filout.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * De serialize.
	 *
	 * @param path the path
	 * @return the object
	 */
	public static Object deSerialize(String path) {

		try {
			File f = new File(path);
			boolean exist = f.exists();
			if (exist) {
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				ois.close();
				fis.close();
				return obj;
			} else {
				return new ArrayList<Personal>();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
	}

	/**
	 * Read names.
	 *
	 * @param path the path
	 * @return the list
	 */
	public static List<String> readNames(String path) {

		List<String> fileArr = null;
		try {
			fileArr = Files.readAllLines(Paths.get(path), CHARSET);
			return fileArr;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Read adress.
	 *
	 * @param path the path
	 * @return the array list
	 */
	public static ArrayList<String> readAdress(String path) {
		ArrayList<String> a = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path), CHARSET)) {
			String line = null;

			while ((line = reader.readLine()) != null) {
				String adress = line;
				line = reader.readLine();

				a.add(adress + " " + line);

			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return a;
	}
}
