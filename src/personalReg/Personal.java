package personalReg;

import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;

public class Personal implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -3869961098372491439L;
	private String namn, adress, phone, postnumber;
	private int age;
	private UUID id;
	private long income;

	public Personal(String namn, String adress, String phone, String postnumber, int age, long income) {

		this.namn = namn;
		this.adress = adress;
		this.phone = phone;
		this.postnumber = postnumber;
		this.age = age;
		this.income = income;
		this.id = UUID.randomUUID();
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @return the income
	 */
	public long getIncome() {
		return income;
	}

	/**
	 * @return the namn
	 */
	public String getNamn() {
		return namn;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the postnumber
	 */
	public String getPostnumber() {
		return postnumber;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(long income) {
		this.income = income;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param postnumber the postnumber to set
	 */
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param namn the namn to set
	 */
	public void setNamn(String namn) {
		this.namn = namn;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nNamn: " + namn + "\nAdress= " + adress + "\nTelefonNr: " + phone + "\nPostNr: " + postnumber
				+ "\nÅlder: " + age + "\nID: " + id + "\nLön: " + income + "\n";
	}

}

class Sortbyage implements Comparator<Personal> {
	// Used for sorting in ascending order of
	// age
	@Override
	public int compare(Personal a, Personal b) {
		return a.getAge() - b.getAge();
	}
}

class Sortbyincome implements Comparator<Personal> {
	// Used for sorting in ascending order of
	// income
	@Override
	public int compare(Personal a, Personal b) {
		return (int) (a.getIncome() - b.getIncome());
	}
}

class Sortbyname implements Comparator<Personal> {
	// Used for sorting in ascending order of
	// name
	@Override
	public int compare(Personal a, Personal b) {
		return a.getNamn().compareTo(b.getNamn());
	}
}