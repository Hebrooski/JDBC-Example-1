package db.fun;
import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4722321898944347539L;
	private long id;
	private String firstName;
	private String lastName;
	private long deptID;
	private long credits;
	
	Employee(){
	}
	
	public Employee(long id, String firstName, String lastName, long deptID, long credits) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setDeptID(deptID);
		setCredits(credits);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getDeptID() {
		return deptID;
	}

	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}

	public long getCredits() {
		return credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", deptID=" + deptID
				+ ", credits=" + credits + "]";
	}
	
	
	
}
