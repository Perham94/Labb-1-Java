package personalReg;


import java.io.IOException;
import java.util.ArrayList;


public class PersonalRegister {

	public static void main(String[] args) {

	}
	public static void start() throws IOException {
		ArrayList<Personal> array = new ArrayList<>();
	
		ConsoleReader cr = new ConsoleReader();

		while (true) {
			System.out.println("1: Avsluta");
			System.out.println("2: Lägg till person");
			System.out.println("3: Visa alla personer");
			System.out.println("4: Läs in alla personer från fil");
			System.out.println("5: Spara alla personer till fil");
			System.out.println("6: Skapa en person automatiskt");
			String s =cr.inStr(); 

			switch (s) {
				case "1" :
					System.out.println("Adjö!");
					return;
				case "2" :
				
					break;
				case "3" :
//					System.out.println("Personer: ");
//					if (array!=null) {
//						for (Personal p : array) {
//							p.visa();
//						}
//					}
					break;
				case "4" :
//					array = (ArrayList<Personal>) deSerialize(ser);
//					System.out.println("Inläst!");
					break;
				case "5" :
//					serialize(array, ser);
//					System.out.println("Sparad!");
					break;
	
			}
		}
	}
}
