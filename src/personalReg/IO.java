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


public class IO {
	private final static Charset CHARSET = Charset.forName("UTF-8");

	public static void read(String path) {

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path), CHARSET)) {
			String line = null;

			while ((line = reader.readLine()) != null) {

				System.out.println(line);
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

	}

	public static void write(String text, String file) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), CHARSET)) {
			writer.write(text, 0, text.length());
			writer.newLine();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	public static void writeAppend(String text, String file) {

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), CHARSET, StandardOpenOption.APPEND)) {
			writer.write(text, 0, text.length());
			writer.newLine();

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	public void serialize(Object obj, String path) {
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

	public Object deSerialize(String path) {

		try {
			File tmpDir = new File(path);
			boolean exists = tmpDir.exists();
			if (exists) {
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				ois.close();
				fis.close();
				return obj;				
			}else {
				return  null;
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
}
