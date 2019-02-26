package personalReg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalRegister.
 */
public class PersonalRegister {

	/** The Constant PATH. */
	private static final String PATH = "personalLista.ser";

	/** The names list. */
	private static String[] namesList;

	/** The adress list. */
	private static ArrayList<String> adressList;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		start();
	}

	/**
	 * Start.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void start() throws IOException {
		ArrayList<Personal> personalLista = deSerialize();
		readInList();
		ConsoleReader cr = new ConsoleReader();

		while (true) {
			System.out.println("1: Lägg till personal");
			System.out.println("2: Visa all personal");
			System.out.println("3: Sök personal");
			System.out.println("4: Sortera personal");
			System.out.println("5: Skapa en personal automatiskt");
			System.out.println("6: Skapa rapport");
			System.out.println("7: Avsluta");
			int in = cr.inInt();

			switch (in) {
			case 1:
				addPost(personalLista);
				break;

			case 2:
				showPost(personalLista);
				break;
			case 3:
				searchPers(personalLista);
				break;
			case 4:
				sortList(personalLista);
				break;
			case 5:
				randomizePersonal(personalLista);
				break;
			case 6:
				createTable(personalLista);
				break;
			case 7:
				serialize(personalLista);
				System.out.println("Adjö!");
				return;
			}
		}
	}

	/**
	 * Creates the table.
	 *
	 * @param personalLista the personal lista
	 */
	private static void createTable(ArrayList<Personal> personalLista) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<style>\r\n" + "table {\r\n"
				+ "  font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n" + "  width: 100%;\r\n"
				+ "}\r\n" + "\r\n" + "td, th {\r\n" + "  border: 1px solid #dddddd;\r\n" + "  text-align: left;\r\n"
				+ "  padding: 8px;\r\n" + "}\r\n" + "\r\n" + "tr:nth-child(even) {\r\n"
				+ "  background-color: #dddddd;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "<h2>Personal Lista</h2>\r\n" + "\r\n" + "<table id=\"myTable2\">\r\n" + "  <tr>\r\n"
				+ "    <th onclick=\"sortTable(0)\">Namn</th>\r\n" + "    <th onclick=\"sortTable(1)\">Adress</th>\r\n"
				+ "    <th  onclick=\"sortTable(2)\">Telefon nummer</th>\r\n"
				+ "	<th  onclick=\"sortTable(3)\">Post nummer</th>\r\n"
				+ "    <th  onclick=\"sortTableNr(4)\">Ålder</th>\r\n"
				+ "	<th  onclick=\"sortTableNr(5)\">Inkomst</th>\r\n" + "	<th onclick=\"sortTable(6)\">UUID</th>\r\n"
				+ "  </tr>");

		for (Personal personal : personalLista) {
			sb.append("<tr>");
			sb.append("<td>" + personal.getNamn() + "</td>");
			sb.append("<td>" + personal.getAdress() + "</td>");
			sb.append("<td>" + personal.getPhone() + "</td>");
			sb.append("<td>" + personal.getPostnumber() + "</td>");
			sb.append("<td>" + personal.getAge() + "</td>");
			sb.append("<td>" + personal.getIncome() + "</td>");
			sb.append("<td>" + personal.getId() + "</td>");
			sb.append("</tr>");
		}
		sb.append("<script>\r\n" + "function sortTable(n) {\r\n"
				+ "  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;\r\n"
				+ "  table = document.getElementById(\"myTable2\");\r\n" + "  switching = true;\r\n"
				+ "  // Set the sorting direction to ascending:\r\n" + "  dir = \"asc\"; \r\n"
				+ "  /* Make a loop that will continue until\r\n" + "  no switching has been done: */\r\n"
				+ "  while (switching) {\r\n" + "    // Start by saying: no switching is done:\r\n"
				+ "    switching = false;\r\n" + "    rows = table.rows;\r\n"
				+ "    /* Loop through all table rows (except the\r\n"
				+ "    first, which contains table headers): */\r\n"
				+ "    for (i = 1; i < (rows.length - 1); i++) {\r\n"
				+ "      // Start by saying there should be no switching:\r\n" + "      shouldSwitch = false;\r\n"
				+ "      /* Get the two elements you want to compare,\r\n"
				+ "      one from current row and one from the next: */\r\n"
				+ "      x = rows[i].getElementsByTagName(\"TD\")[n];\r\n"
				+ "      y = rows[i + 1].getElementsByTagName(\"TD\")[n];\r\n"
				+ "      /* Check if the two rows should switch place,\r\n"
				+ "      based on the direction, asc or desc: */\r\n" + "      if (dir == \"asc\") {\r\n"
				+ "        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {\r\n"
				+ "          // If so, mark as a switch and break the loop:\r\n" + "          shouldSwitch = true;\r\n"
				+ "          break;\r\n" + "        }\r\n" + "      } else if (dir == \"desc\") {\r\n"
				+ "        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {\r\n"
				+ "          // If so, mark as a switch and break the loop:\r\n" + "          shouldSwitch = true;\r\n"
				+ "          break;\r\n" + "        }\r\n" + "      }\r\n" + "    }\r\n" + "    if (shouldSwitch) {\r\n"
				+ "      /* If a switch has been marked, make the switch\r\n"
				+ "      and mark that a switch has been done: */\r\n"
				+ "      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\r\n" + "      switching = true;\r\n"
				+ "      // Each time a switch is done, increase this count by 1:\r\n" + "      switchcount ++; \r\n"
				+ "    } else {\r\n" + "      /* If no switching has been done AND the direction is \"asc\",\r\n"
				+ "      set the direction to \"desc\" and run the while loop again. */\r\n"
				+ "      if (switchcount == 0 && dir == \"asc\") {\r\n" + "        dir = \"desc\";\r\n"
				+ "        switching = true;\r\n" + "      }\r\n" + "    }\r\n" + "  }\r\n" + "}\r\n"
				+ "function sortTableNr(n) {\r\n"
				+ "  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;\r\n"
				+ "  table = document.getElementById(\"myTable2\");\r\n" + "  switching = true;\r\n"
				+ "  //Set the sorting direction to ascending:\r\n" + "  dir = \"asc\"; \r\n"
				+ "  /*Make a loop that will continue until\r\n" + "  no switching has been done:*/\r\n"
				+ "  while (switching) {\r\n" + "    //start by saying: no switching is done:\r\n"
				+ "    switching = false;\r\n" + "    rows = table.rows;\r\n"
				+ "    /*Loop through all table rows (except the\r\n"
				+ "    first, which contains table headers):*/\r\n"
				+ "    for (i = 1; i < (rows.length - 1); i++) {\r\n"
				+ "      //start by saying there should be no switching:\r\n" + "      shouldSwitch = false;\r\n"
				+ "      /*Get the two elements you want to compare,\r\n"
				+ "      one from current row and one from the next:*/\r\n"
				+ "      x = rows[i].getElementsByTagName(\"TD\")[n];\r\n"
				+ "      y = rows[i + 1].getElementsByTagName(\"TD\")[n];\r\n"
				+ "      /*check if the two rows should switch place,\r\n"
				+ "      based on the direction, asc or desc:*/\r\n" + "      if (dir == \"asc\") {\r\n"
				+ "        if (Number(x.innerHTML) > Number(y.innerHTML)) {\r\n"
				+ "          //if so, mark as a switch and break the loop:\r\n" + "          shouldSwitch= true;\r\n"
				+ "          break;\r\n" + "        }\r\n" + "      } else if (dir == \"desc\") {\r\n"
				+ "        if (Number(x.innerHTML) < Number(y.innerHTML)) {\r\n"
				+ "          //if so, mark as a switch and break the loop:\r\n" + "          shouldSwitch = true;\r\n"
				+ "          break;\r\n" + "        }\r\n" + "      }\r\n" + "    }\r\n" + "    if (shouldSwitch) {\r\n"
				+ "      /*If a switch has been marked, make the switch\r\n"
				+ "      and mark that a switch has been done:*/\r\n"
				+ "      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\r\n" + "      switching = true;\r\n"
				+ "      //Each time a switch is done, increase this count by 1:\r\n"
				+ "      switchcount ++;      \r\n" + "    } else {\r\n"
				+ "      /*If no switching has been done AND the direction is \"asc\",\r\n"
				+ "      set the direction to \"desc\" and run the while loop again.*/\r\n"
				+ "      if (switchcount == 0 && dir == \"asc\") {\r\n" + "        dir = \"desc\";\r\n"
				+ "        switching = true;\r\n" + "      }\r\n" + "    }\r\n" + "  }\r\n" + "}</script>");
		sb.append("</html>");

		IO.write(sb.toString(), "rapport.html");

	}

	/**
	 * Sort list.
	 *
	 * @param personalLista the personal lista
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	/**
	 * Read in list.
	 */
	private static void readInList() {
		namesList = IO.readNames("names.txt").get(0).replace("\"", "").split(",");
		adressList = IO.readAdress("adressList.txt");
	}

	/**
	 * Randomize personal.
	 *
	 * @param personalLista the personal lista
	 */
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

	/**
	 * Search pers.
	 *
	 * @param personalLista the personal lista
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void searchPers(ArrayList<Personal> personalLista) throws IOException {

		ConsoleReader cr = new ConsoleReader();

		int elementIndex = 0;
		System.out.println("Vad söker du efter?" + " 1.Namn 2.Ålder 3.Adress 4.telefon nummer 5.post nummer 6.lön");
		int in = cr.inInt();
		System.out.println("Ange vad du vill söka:");
		String text = cr.inStr();

		for (Personal p : personalLista) {
			switch (in) {

			case 1:
				if (p.getNamn().contains(text)) {
					elementIndex = personalLista.indexOf(p);
					System.out.println("found\n " + personalLista.get(personalLista.indexOf(p)));

				}
				break;
			case 2:
				if (p.getAge() == Integer.parseInt(text)) {
					elementIndex = personalLista.indexOf(p);
					System.out.println("Personal Found\n " + personalLista.get(personalLista.indexOf(p)));
				}

				break;
			case 3:
				if (p.getAdress().contains(text)) {
					elementIndex = personalLista.indexOf(p);
					System.out.println("found\n " + personalLista.get(personalLista.indexOf(p)));
				}
				break;
			case 4:
				if (p.getPhone().contains(text)) {
					elementIndex = personalLista.indexOf(p);
					System.out.println("found\n " + personalLista.get(personalLista.indexOf(p)));
				}

				break;
			case 5:
				if (p.getPostnumber().contains(text)) {
					elementIndex = personalLista.indexOf(p);
					System.out.println("found\n " + personalLista.get(personalLista.indexOf(p)));
				}

				break;
			case 6:
				if (p.getIncome() == Long.parseLong(text)) {
					elementIndex = personalLista.indexOf(p);
					System.out.println("found\n " + personalLista.get(personalLista.indexOf(p)));
				}

				break;

			}
		}
		System.out
				.println("Vill du göra? 1. Ta bort personal 2.Rediger Personal, " + "tryck på övrigt Inget av dessa: ");
		int task = cr.inInt();
		if (task == 1) {
			deletePost(personalLista, elementIndex);

		}
		if (task == 2) {
			editPost(personalLista, elementIndex);

		}
	}

	/**
	 * Show post.
	 *
	 * @param personalLista the personal lista
	 */
	private static void showPost(ArrayList<Personal> personalLista) {
		for (Personal index : personalLista) {
			System.out.println(index);
		}
	}

	/**
	 * Delete post.
	 *
	 * @param personalLista the personal lista
	 * @param index         the index
	 */
	private static void deletePost(ArrayList<Personal> personalLista, int index) {

		personalLista.remove(index);

	}

	/**
	 * Serialize.
	 *
	 * @param personalLista the personal lista
	 */
	private static void serialize(ArrayList<Personal> personalLista) {
		IO.serialize(personalLista, PATH);
	}

	/**
	 * De serialize.
	 *
	 * @return the array list
	 */
	private static ArrayList<Personal> deSerialize() {

		@SuppressWarnings("unchecked")

		ArrayList<Personal> personalLista = (ArrayList<Personal>) IO.deSerialize(PATH);

		if (personalLista == null) {
			return new ArrayList<Personal>();
		}
		return personalLista;
	}

	/**
	 * Edits the post.
	 *
	 * @param personalLista the personal lista
	 * @param index         the index
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void editPost(ArrayList<Personal> personalLista, int index) throws IOException {

		ConsoleReader cr = new ConsoleReader();

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

	/**
	 * Adds the post.
	 *
	 * @param personalLista the personal lista
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
