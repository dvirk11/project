package Entity;
import java.io.Serializable;


/***
 * 
 * Entity class to define a Copy of a Book in the system
 *
 */
public class Bookcopys implements Serializable {
	/**
	 * Book id
	 */
	private String idbook;
	/**
	 * Copy of a Book id
	 */
	private String copyid;
	/**
	 * status of the Copy 
	 */
	private String status;
	
	
	/***
	 * Constructor for the server side Employees
	 * 
	 * @param idbook
	 *           Book ID number
	 * @param copyid
	 *            Copy of a Book id
	 * @param status 
     *            status of the Copy
	 * 
	 */
	public Bookcopys(String idbook, String copyid, String status) {
		super();
		this.idbook = idbook;
		this.copyid = copyid;
		this.status = status;
	}
	/***
	 * 
	 * @return the Book ID
	 */
	public String getIdbook() {
		return idbook;
	}
	/***
	 * 
	 * @param Book ID
	 *            to set
	 */
	public void setIdbook(String idbook) {
		this.idbook = idbook;
	}
	/***
	 * 
	 * @return the Copy of a Book id
	 */
	public String getCopyid() {
		return copyid;
	}
	/***
	 * 
	 * @param Copy of a Book id
	 *            to set
	 */
	public void setCopyid(String copyid) {
		this.copyid = copyid;
	}
	/***
	 * 
	 * @return the status of the Copy
	 */
	public String getStatus() {
		return status;
	}
	/***
	 * 
	 * @param status of the Copy
	 *            to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
