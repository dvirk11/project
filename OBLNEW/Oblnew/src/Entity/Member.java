package Entity;
import java.io.Serializable;

/***
 * 
 * Entity class to define a Member in the system
 *
 */
public class Member implements Serializable {
	
	/**
	 * state is logged in
	 */
	private boolean isLogged;
	/**
	 * Member id
	 */
	private String MemberID;
	/**
	 * Member Last name
	 */
	private String Lastname;
	/**
	 * Member First name
	 */
	private String Firstname;
	/**
	 * Member subscription number 
	 */
	private String subscriptionMember;
	/**
	 * Member name for log in
	 */
	private String Username;
	/**
	 * Member Password for log in
	 */
	private String Password;
	/**
	 * Member Phone number to sent reminder messages
	 */
	private String Phonenumber;
	/**
	 * Member Email to sent reminder messages
	 */
	private String Email;
	/**
	 * Member Graduation year to know when to block his membership
	 */
	private int Graduationyear;
	/**
	 *  Status of the Member
	 */
	private String Status;

	/***
	 * Constructor for the server side member
	 */
	
	
	public Member(boolean isLogged, String memberID, String lastname, String firstname, String subscriptionMember,
			String username, String password, String phonenumber, String email, int graduationyear, String status) {
		super();
		this.isLogged = isLogged;
		MemberID = memberID;
		Lastname = lastname;
		Firstname = firstname;
		this.subscriptionMember = subscriptionMember;
		Username = username;
		Password = password;
		Phonenumber = phonenumber;
		Email = email;
		Graduationyear = graduationyear;
		Status = status;
	}
	/***
	 * Constructor for the server side member
	 * 
	 * @param username
	 *            user name
	 * @param password
	 *            password         
	 */
	public Member(String username, String password) {
		Username = username;
		Password = password;
		
		
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
	 * @return the Member ID
	 */
	public String getMemberID() {
		return MemberID;
	}
	/***
	 * 
	 * @param Member ID
	 *            to set
	 */
	public void setMemberID(String memberID) {
		MemberID = memberID;
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
	 * @return the Subscription Member
	 */
	public String getSubscriptionMember() {
		return subscriptionMember;
	}
	/***
	 * 
	 * @param the Subscription Member
	 *            to set
	 */
	public void setSubscriptionMember(String subscriptionMember) {
		this.subscriptionMember = subscriptionMember;
	}
	/***
	 * 
	 * @return the User name
	 */
	public String getUsername() {
		return Username;
	}
	/***
	 * 
	 * @param the User name
	 *            to set
	 */
	public void setUsername(String username) {
		Username = username;
	}
	/***
	 * 
	 * @return Member's password
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
	 * @return Phone number
	 */
	public String getPhonenumber() {
		return Phonenumber;
	}
	/***
	 * 
	 * @param Phone number
	 *            to set
	 */
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
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
	 * @return Graduation year
	 */
	public int getGraduationyear() {
		return Graduationyear;
	}
	/***
	 * 
	 * @param Graduation year
	 *            to set
	 */
	public void setGraduationyear(int graduationyear) {
		Graduationyear = graduationyear;
	}
	/***
	 * 
	 * @return Status
	 */
	public String getStatus() {
		return Status;
	}
	/***
	 * 
	 * @param Status
	 *            to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	
	
}
