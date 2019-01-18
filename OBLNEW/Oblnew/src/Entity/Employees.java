package Entity;
import java.io.Serializable;



/***
 * 
 * Entity class to define a Employees in the system
 *
 */
public class Employees implements Serializable  {
	/**
	 * Employees id
	 */
	private String ID;
	/**
	 * Employees Last name
	 */
	private String Lastname;
	/**
	 * Employees First name
	 */
	private String Firstname;
	/**
	 * Employees Worker number 
	 */
	private String WorkerNumber;
	/**
	 * Employees Password for log in
	 */
	private String Password;
	/**
	 * Employees Email 
	 */
	private String Email;
	/**
	 * state is logged in
	 */
	private boolean isLogged;
	/**
	 * permission of the Employees
	 */
	private boolean permission;

	/***
	 * Constructor for the server side Employees
	 * 
	 * @param iD
	 *           Employees ID number
	 * @param isLogged
	 *            is online
	 * @param lastname 
                  Employees last name 
	 * @param firstname 
                  Employees first name
	 * @param workerNumber 
                  worker Number of the Employee
	 * @param permission
	 *            permission of the Employee
	 * @param password
	 *            password
	 *@param email        
	 */
	
	public Employees(String iD, String lastname, String firstname, String workerNumber, String password, String email,
			boolean isLogged, boolean permission) {
		super();
		ID = iD;
		Lastname = lastname;
		Firstname = firstname;
		WorkerNumber = workerNumber;
		Password = password;
		Email = email;
		this.isLogged = isLogged;
		this.permission = permission;
	}
	/***
	 * 
	 * @return the Employee ID
	 */
	public String getID() {
		return ID;
	}
	/***
	 * 
	 * @param Employee ID
	 *            to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/***
	 * 
	 * @return the Last name
	 */
	public String getLastname() {
		return Lastname;
	}
	/***
	 * 
	 * @param Last name
	 *            to set
	 */
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	/***
	 * 
	 * @return the First name
	 */
	public String getFirstname() {
		return Firstname;
	}
	/***
	 * 
	 * @param First name
	 *            to set
	 */
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	/***
	 * 
	 * @return the Worker Number
	 */
	public String getWorkerNumber() {
		return WorkerNumber;
	}
	/***
	 * 
	 * @param Worker Number
	 *            to set
	 */
	public void setWorkerNumber(String workerNumber) {
		WorkerNumber = workerNumber;
	}
	/***
	 * 
	 * @return Employee's password
	 */
	public String getPassword() {
		return Password;
	}
	/***
	 * 
	 * @param password
	 *            to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/***
	 * 
	 * @return Email
	 */
	public String getEmail() {
		return Email;
	}
	/***
	 * 
	 * @param Email
	 *            to set
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/***
	 * 
	 * @return the logged state
	 */
	public boolean isLogged() {
		return isLogged;
	}
	/***
	 * 
	 * @param isLogged
	 *            to set
	 */
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	/***
	 * 
	 * @return the permission
	 */
	public boolean isPermission() {
		return permission;
	}
	/***
	 * 
	 * @param permission
	 *            to set
	 */
	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	
	
}
