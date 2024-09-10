package management.templates;

public class Student 
{
	final public static double FEES = 15000;	
	final private String studentId;
	final private String studentName;
	final private long studentAdhaarNumber;
	private String studentDOB;
	private String studentAddress;
	private double studentFees;
	private String feesStatus;
	private String username;
	private String password;
	
	public Student(String studentId, String studentName, long studentAdhaarNumber, String studentDOB,
			String studentAddress, double studentFees) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAdhaarNumber = studentAdhaarNumber;
		this.studentDOB = studentDOB;
		this.studentAddress = studentAddress;
		this.studentFees = studentFees;
		if(studentFees == FEES)
			setFeesStatus("Paid");
		else 
			setFeesStatus("Not Paid");
		System.out.println("Student has been added successfully!!!");
//		showCredentials();
	}
	
//	private void showCredentials() {
//		System.out.println("Student crendentials : ");
//		System.out.println("Username : " + username);
//		System.out.println("Password : " + password);
//		System.out.println("For the time being, the password is set to be identical to the username. \nStudents will have the option to change their password later using their username for authentication.");
//	}
	
	
	public String getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public long getStudentAdhaarNumber() {
		return studentAdhaarNumber;
	}
	
	public String getStudentDOB() {
		return studentDOB;
	}
	
	public String getStudentAddress() {
		return studentAddress;
	}
	
	public void setStudentDOB(String dOB) {
		studentDOB = dOB;
	}
	
	public void setStudentAddress(String address) {
		this.studentAddress = address;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getStudentFees() {
		return studentFees;
	}

	public void setStudentFees(double studentFees) {
		this.studentFees = studentFees;
	}

	public String getFeesStatus() {
		return feesStatus;
	}

	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}
}