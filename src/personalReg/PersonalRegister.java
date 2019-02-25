package personalReg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PersonalRegister {

	private static final String PATH = "personalLista.ser";
	private static String[] namesList;
	private static ArrayList<String> adressList;

	public static void main(String[] args) throws IOException {
		start();

	}

	public static void start() throws IOException {
		ArrayList<Personal> personalLista = deSerialize();

		readInList();
		ConsoleReader cr = new ConsoleReader();

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
				searchPers(personalLista);
				break;
			case 6:
				break;
			case 7:
				randomizePersonal(personalLista);
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


	private static void readInList() {
		namesList = IO.readNames("names.txt").get(0).replace("\"", "").split(",");
		adressList = IO.readAdress("adressList.txt");
	}

	private static void randomizePersonal(ArrayList<Personal> personalLista) {

		Random rand = new java.util.Random();

		String namn = namesList[rand.nextInt(namesList.length)] + " " + namesList[rand.nextInt(namesList.length)];
		String[] adress = adressList.get(rand.nextInt(adressList.size())).split(",");
		String phone = "" + (int)Math.floor(Math.random() * ((999)) + 10) + "-"
				+ (long)Math.floor(Math.random() * ((9999999)) + 1000000);
		int age = (int) Math.floor(Math.random() * ((150)) + 18);
		long wage = (long) Math.floor(Math.random() * ((999999)) + 90000);
		personalLista.add(new Personal(namn, adress[0], phone, adress[1], age, wage));

		
	}

	@SuppressWarnings("null")
	private static void searchPers(ArrayList<Personal> personalLista) throws IOException {
		ConsoleReader cr = new ConsoleReader();
		System.out.println("Vad söker du efter? 1. Personal namn , 2. Personal ålder  "
				+ ", 3. Personal Telefon Nummer , 4. Personal Adress, " + "5. Personal Postnummer + "
				+ "6. Personal Lön");

		Personal index = null;
		String namn;

		switch (cr.inInt()) {

		case 1:
			if (index.getNamn().matches(cr.inStr())) {
				personalLista.indexOf(index.namn);
			}
			break;
		case 2:
			if (index.getAge() == cr.inInt()) {

			}
			break;

		case 3:
			if (index.getPhone().matches(cr.inStr())) {

			}
			break;

		case 4:
			if (index.getAdress().matches(cr.inStr())) {

			}
			break;
		case 5:
			if (index.getPostnumber().matches(cr.inStr())) {

			}
			break;

		case 6:
			if (index.getIncome() == cr.inLong()) {

			}
			break;
		}

	}

	private static void showPost(ArrayList<Personal> personalLista) {
		for (Personal index : personalLista) {

			System.out.println(index);
		}

	}

	private static void deletePost() {

	}

	private static void serialize(ArrayList<Personal> personalLista) {
		IO.serialize(personalLista, PATH);
	}

	private static ArrayList<Personal> deSerialize() {

		@SuppressWarnings("unchecked")

		ArrayList<Personal> personalLista = (ArrayList<Personal>) IO.deSerialize(PATH);

		if (personalLista == null) {
			return new ArrayList<Personal>();
		}
		return personalLista;
	}

	private static void editPost() {

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
		System.out.println("lön: ");
		long income = cr.inLong();
		personalLista.add(new Personal(namn, adress, phone, postnumber, age, income));
	}

}
