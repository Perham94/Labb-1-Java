package personalReg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
				editPost(personalLista);
				break;
			case 3:
				deletePost(personalLista);
				break;
			case 4:
				showPost(personalLista);
				break;
			case 5:
				searchPers(personalLista);
				break;
			case 6:
				sortList(personalLista);
				break;
			case 7:
				randomizePersonal(personalLista);
				break;
			case 8:
				createTable(personalLista);
				break;
			case 9:
				serialize(personalLista);
				System.out.println("Adjö!");
				return;
			}
		}
	}

	private static void createTable(ArrayList<Personal> personalLista) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<style>\r\n" + "table {\r\n"
				+ "  font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n" + "  width: 100%;\r\n"
				+ "}\r\n" + "\r\n" + "td, th {\r\n" + "  border: 1px solid #dddddd;\r\n" + "  text-align: left;\r\n"
				+ "  padding: 8px;\r\n" + "}\r\n" + "\r\n" + "tr:nth-child(even) {\r\n"
				+ "  background-color: #dddddd;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "<h2>Personal Lista</h2>\r\n" + "\r\n" + "<table>\r\n" + "  <tr>\r\n" + "    <th>Namn</th>\r\n"
				+ "    <th>Adress</th>\r\n" + "    <th>Telefon nummer</th>\r\n" + "	<th>Post nummer</th>\r\n"
				+ "    <th>Ålder</th>\r\n" + "	<th>Inkomst</th>\r\n" + "	<th>UUID</th>\r\n" + "  </tr>");

		for (Personal personal : personalLista) {
			sb.append("<tr>");
			sb.append("<td>"+personal.getNamn()+"</td>");
			sb.append("<td>"+personal.getAdress()+"</td>");
			sb.append("<td>"+personal.getPhone()+"</td>");
			sb.append("<td>"+personal.getPostnumber()+"</td>");
			sb.append("<td>"+personal.getAge()+"</td>");
			sb.append("<td>"+personal.getIncome()+"</td>");
			sb.append("<td>"+personal.getId()+"</td>");
			sb.append("</tr>");
		}
		
		sb.append("</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		IO.write(sb.toString(),"rapport.html");
	}

	private static void sortList(ArrayList<Personal> personalLista) throws IOException {

		ConsoleReader cr = new ConsoleReader();

		while (true) {
			System.out.println("1: Sortera efter namn");
			System.out.println("2: Sortera efter ålder");
			System.out.println("3: Sortera efter lön");

			int in = cr.inInt();

			switch (in) {
			case 1:
				Collections.sort(personalLista, new Sortbyname());
				return;
			case 2:
				Collections.sort(personalLista, new Sortbyage());
				return;
			case 3:
				Collections.sort(personalLista, new Sortbyincome());
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

		String phone = "" + (int) Math.floor(Math.random() * ((999)) + 10) + "-"
				+ (long) Math.floor(Math.random() * ((9999999)) + 1000000);
		int age = (int) Math.floor(Math.random() * ((150)) + 18);
		long wage = (long) Math.floor(Math.random() * ((999999)) + 90000);
		personalLista.add(new Personal(namn, adress[0], phone, adress[1], age, wage));
	}

	private static int searchPers(ArrayList<Personal> personalLista) throws IOException {

		ConsoleReader cr = new ConsoleReader();

		System.out.println("Vad söker du efter?" + " 1.Namn 2.Ålder 3.Adress 4.telefon nummer 5.post nummer 6.lön");

		int elementIndex = 0;
		int in = cr.inInt();
		String text = cr.inStr();

		for (Personal p : personalLista) {
			System.out.println("Ange vad du vill söka");
			switch (in) {

			case 1:
				if (p.getNamn().contains(text)) {
					System.out.println("found " + personalLista.get(personalLista.indexOf(p)));
					elementIndex = personalLista.indexOf(p);
				}
				break;
			case 2:
				if (p.getAge() == Integer.parseInt(text)) {
					System.out.println("found " + personalLista.get(personalLista.indexOf(p)));
					elementIndex = personalLista.indexOf(p);
				}
				break;
			case 3:
				if (p.getAdress().contains(text)) {
					System.out.println("found " + personalLista.get(personalLista.indexOf(p)));
					elementIndex = personalLista.indexOf(p);
				}
				break;
			case 4:
				if (p.getPhone().contains(text)) {
					System.out.println("found " + personalLista.get(personalLista.indexOf(p)));
					elementIndex = personalLista.indexOf(p);
				}
				break;
			case 5:
				if (p.getPostnumber().contains(text)) {
					System.out.println("found " + personalLista.get(personalLista.indexOf(p)));
					elementIndex = personalLista.indexOf(p);
				}
				break;
			case 6:
				if (p.getIncome() == Long.parseLong(text)) {
					System.out.println("found " + personalLista.get(personalLista.indexOf(p)));
					elementIndex = personalLista.indexOf(p);
				}
				break;
			}
		}

		return elementIndex;
	}

	private static void showPost(ArrayList<Personal> personalLista) {
		for (Personal index : personalLista) {
			System.out.println(index);
		}
	}

	private static void deletePost(ArrayList<Personal> personalLista) throws IOException {
		System.out.println("Vem ska gå bort: ");
		int index = searchPers(personalLista);
		personalLista.remove(index);

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

	private static void editPost(ArrayList<Personal> personalLista) throws IOException {
		System.out.println("Vem ska gå bort: ");
		ConsoleReader cr = new ConsoleReader();
		int index = searchPers(personalLista);

		Personal p = personalLista.get(index);
		System.out.print("Ändra Namn");
		p.setNamn(cr.inStr());
		System.out.print("Ändra Adress");
		p.setAdress(cr.inStr());
		System.out.print("Ändra Telefon");
		p.setPhone(cr.inStr());
		System.out.print("Ändra Post");
		p.setPostnumber(cr.inStr());
		System.out.print("Ändra Ålder");
		p.setAge(cr.inInt());
		System.out.print("Ändra Lön");
		p.setIncome(cr.inLong());

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
