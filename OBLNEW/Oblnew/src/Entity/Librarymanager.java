package Entity;
import java.io.Serializable;



/***
 * 
 * Entity class to define a Library manager in the system
 *
 */
public class Librarymanager extends  Employees {

	
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
	public Librarymanager(String iD, String lastname, String firstname, String workerNumber, String password,
			String email, boolean isLogged, boolean permission) {
		super(iD, lastname, firstname, workerNumber, password, email, isLogged, permission);
		// TODO Auto-generated constructor stub
	}

}
