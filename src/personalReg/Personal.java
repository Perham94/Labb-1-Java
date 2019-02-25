package personalReg;

import java.io.Serializable;

public class Personal implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -3869961098372491439L;
	String namn, adress, phone, postnumber;
	int age, id;
	long income;

	public Personal(String namn, String adress, String phone, String postnumber, int age, int id, long income) {

		this.namn = namn;
		this.adress = adress;
		this.phone = phone;
		this.postnumber = postnumber;
		this.age = age;
		this.id = id;
		this.income = income;
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
	public int getId() {
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
	public void setId(int id) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personal [namn=" + namn + ", adress=" + adress + ", phone=" + phone + ", postnumber=" + postnumber
				+ ", age=" + age + ", id=" + id + ", income=" + income + "]";
	}

}
