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
		deSerialize();
		while (true) {
			System.out.println("1: Lägg till personal");
			System.out.println("2: Editera personal");
			System.out.println("3: Radera personal");
			System.out.println("4: Visa all personal");
			System.out.println("5: Sök personal");
			System.out.println("6: Sortera personal");
			System.out.println("7: Skapa en personal automatiskt");
			System.out.println("8: Skapa rapport");
			System.out.println("9: Avsluta");
			int in = cr.inInt();

			switch (in) {
			case 1:
				addPost(personalLista);
				break;
			case 2:
				editPost();
				break;
			case 3:
				deletePost();
				break;
			case 4:
				showPost();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				serialize();
				System.out.println("Adjö!");
				return;
			}
		}
	}

	private static void showPost() {
		// TODO Auto-generated method stub

	}

	private static void deletePost() {
		// TODO Auto-generated method stub

	}

	private static void serialize() {
		// TODO Auto-generated method stub

	}

	private static void deSerialize() {
		// TODO Auto-generated method stub

	}

	private static void editPost() {
		// TODO Auto-generated method stub

	}

	private static void addPost(ArrayList<Personal> personalLista) throws IOException {
		ConsoleReader cr = new ConsoleReader();

		personalLista
				.add(new Personal(cr.inStr(), cr.inStr(), cr.inStr(), cr.inStr(), cr.inInt(), cr.inInt(), cr.inInt()));
	}

}
