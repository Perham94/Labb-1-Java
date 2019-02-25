package personalReg;


import java.io.IOException;
import java.util.ArrayList;


public class PersonalRegister {

	public static void main(String[] args) throws IOException {
start();
	}
	public static void start() throws IOException {
		ArrayList<Personal> personalLista = new ArrayList<>();
	
		ConsoleReader cr = new ConsoleReader();

		while (true) {
			System.out.println("1: Lägg till personal");
			System.out.println("2: Editera personal");
			System.out.println("3: Radera personal");
			System.out.println("4: Visa all personal");
			System.out.println("5: Sök personal");
			System.out.println("6: Sortera personal");			
			System.out.println("7: Skapa en personal automatiskt");
			System.out.println("8: Spara alla personal till fil");
			System.out.println("9: Läs in alla personal från fil");
			System.out.println("10: Avsluta");
			int in =cr.inInt(); 
			
			switch (in) {
				case 1 :
					addPost();
					break;
				case 2 :
					editPost();
					break;
				case 3 :
					break;
				case 4 :
					break;
				case 5 :
					break;
				case 6 :
					break;
				case 7 :
					break;
				case 8 :
					break;
				case 9 :
					break;
				case 10 :
					System.out.println("Adjö!");
					return;
			}
		}
	}
	private static void editPost() {
		// TODO Auto-generated method stub
		
	}
	private static void addPost() {
		// TODO Auto-generated method stub
		
	}
}
