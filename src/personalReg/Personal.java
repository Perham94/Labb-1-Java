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

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the postnumber
	 */
	public String getPostnumber() {
		return postnumber;
	}

	/**
	 * @param postnumber the postnumber to set
	 */
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the income
	 */
	public long getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(long income) {
		this.income = income;
	}

	/**
	 * @return the namn
	 */
	public String getNamn() {
		return namn;
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

	public Personal(String namn, String adress, String phone, String postnumber, int age, int id, long income) {

		this.namn = namn;
		this.adress = adress;
		this.phone = phone;
		this.postnumber = postnumber;
		this.age = age;
		this.id = id;
		this.income = income;
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
