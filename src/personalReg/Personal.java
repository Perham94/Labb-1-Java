package personalReg;

import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;


/**
 * The Class Personal.
 */
public class Personal implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3869961098372491439L;

	/** The postnumber. */
	private String namn, adress, phone, postnumber;

	/** The age. */
	private int age;

	/** The id. */
	private UUID id;

	/** The income. */
	private long income;

	/**
	 * Instantiates a new personal.
	 *
	 * @param namn       the namn
	 * @param adress     the adress
	 * @param phone      the phone
	 * @param postnumber the postnumber
	 * @param age        the age
	 * @param income     the income
	 */
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
	 * Gets the adress.
	 *
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Gets the income.
	 *
	 * @return the income
	 */
	public long getIncome() {
		return income;
	}

	/**
	 * Gets the namn.
	 *
	 * @return the namn
	 */
	public String getNamn() {
		return namn;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Gets the postnumber.
	 *
	 * @return the postnumber
	 */
	public String getPostnumber() {
		return postnumber;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Sets the income.
	 *
	 * @param income the income to set
	 */
	public void setIncome(long income) {
		this.income = income;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Sets the postnumber.
	 *
	 * @param postnumber the postnumber to set
	 */
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Sets the namn.
	 *
	 * @param namn the namn to set
	 */
	public void setNamn(String namn) {
		this.namn = namn;
	}

	/**
	 * Sets the adress.
	 *
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * Sets the age.
	 *
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