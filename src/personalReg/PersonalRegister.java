package personalReg;

import java.io.IOException;
import java.util.ArrayList;

public class PersonalRegister {

	private static final String PATH = "personalLista.ser";

	public static void main(String[] args) throws IOException {
		start();

	}

	public static void start() throws IOException {
		ArrayList<Personal> personalLista = new ArrayList<>();

		ConsoleReader cr = new ConsoleReader();
		personalLista = deSerialize();
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
				showPost(personalLista);
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
				serialize(personalLista);
				System.out.println("Adjö!");
				return;
			}
		}
	}

	private static void showPost(ArrayList<Personal> personalLista) {
		for (Personal index : personalLista) {

			System.out.println(index);
		}

	}

	private static void deletePost() {
		// TODO Auto-generated method stub

	}

	private static void serialize(ArrayList<Personal> personalLista) {
		IO in = new IO();
		in.serialize(personalLista, PATH);
	}

	private static ArrayList<Personal> deSerialize() {
		IO in = new IO();
		@SuppressWarnings("unchecked")
		ArrayList<Personal> personalLista = (ArrayList<Personal>) in.deSerialize(PATH);
		return personalLista;
	}

	private static void editPost() {
		// TODO Auto-generated method stub

	}

	private static void addPost(ArrayList<Personal> personalLista) throws IOException {
		ConsoleReader cr = new ConsoleReader();
		System.out.println("Namn: ");
		String namn = cr.inStr();
		System.out.println("Adress: ");
		String adress = cr.inStr();
		System.out.println("Telefon Nummer: ");
		String phone = cr.inStr();
		System.out.println("Post Nummer: ");
		String postnumber = cr.inStr();
		System.out.println("Ålder: ");
		int age = cr.inInt();
		System.out.println("id: ");
		int id = cr.inInt();
		System.out.println("lön: ");
		int income = cr.inInt();
		personalLista.add(new Personal(namn, adress, phone, postnumber, age, id, income));
	}

}
