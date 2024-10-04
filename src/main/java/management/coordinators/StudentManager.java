package management.coordinators;

import java.util.LinkedHashMap;
import management.templates.Student;
import management.templates.StudentIdAccess;

public class StudentManager extends Coordinator implements GeneralReport, StudentIdAccess{

	private LinkedHashMap<String,Student> student = new LinkedHashMap<String,Student>();
	static int capacity = 0;
		
	private static final StudentManager Administrator = new StudentManager();
	
    private StudentManager(){}
    
    public static StudentManager getInstance() {
        return Administrator;
    }
    
    @Override
    public boolean containsStudentId(String studentId) {
    	return student.containsKey(studentId);
    }
    
    public StudentManager controlPanel() {
    	Boolean check = true;    	
    	while(check) {
			System.out.println("\n---------------------------------------------");
    		System.out.println("Student Manager Control Panel : ");
			System.out.println("---------------------------------------------");
    		System.out.println("1. Add Student Details");
    		System.out.println("2. Update Student Details");
    		System.out.println("3. Get Student Details");
    		System.out.println("4. Generate Student Report");
    		System.out.println("5. Delete Student Details");
    		System.out.println("6. View General Reports");
    		System.out.println("0. Log out");
			System.out.println("---------------------------------------------");
    		System.out.println("Enter your choice : ");
    		int choice = sc.nextInt();
    		
    		switch(choice) 
    		{
	    		case 1:
		    		{
						addStudentDetails();
					}
				break;	    		
	    		case 2:
		    		{		    			
		    			updateStudentDetails();	    			
		    		}
					break;
	    		case 3:
		    		{		    			
		    			System.out.println("Enter student id: ");
		    			String studentId = sc.next();
		    			System.out.println();
		    					    			
		    			if(student.containsKey(studentId)) {
		    				getStudentDetails(studentId);		    		
		    			}
		    			else {
		    				System.out.println("Student Id is incorrect!");
		    			}
		    		}
					break;
	    		case 4:
		    		{
		    			generateStudentReport();
		    		}
					break;
	    		case 5:
		    		{		    			
		    			System.out.println("Enter student id: ");
		    			String studentId = sc.next();
		    			
		    			if(student.containsKey(studentId)) {
		    				deleteStudentDetails(studentId);	    		
		    			}
		    			else {
		    				System.out.println("Student Id is incorrect!");
		    			}
		    		}
					break;
	    		case 6:
		    		{
		    			viewStudentDetails();
		    		}
					break;
	    		case 0:
		    		{
		    			System.out.println("Are you sure you want to exit?(Y/N)");
		    			char ch = sc.next().charAt(0);
		    			if(ch == 'Y' || ch == 'y')
		    			{
		    				System.out.println("Logged Out Successfully");
		    				check = false;
		    			}
		    			
		    		}
	    		break;
	    		default:
		    		{
		    			System.out.println("Invalid Choice!");
		    		}
    			}
    	}
    	return null;
    	
    }
	
    public void addStudentDetails() {
		if(student.size() < totalIntake) {
			//Here the ID should be in string format and it should also be encoded
			String studentId = "Student@" + ++capacity;
			sc.nextLine();
			System.out.println("--------------------------");
			System.out.println("Enter Student Details :");
			System.out.println("--------------------------");	
			
			System.out.println("Enter Student Name : ");
			String studentName = sc.nextLine();	
			
			long studentAdhaarNumber = 0;
			do {
				System.out.println("Enter Adhaar Number : ");
				studentAdhaarNumber = sc.nextLong();
				try {
					if(studentAdhaarNumber <= 111111111111l || studentAdhaarNumber >= 999999999999l) {
						throw new InvalidAdhaarNumber();
					}
				}
				catch(InvalidAdhaarNumber num){
					System.out.println("Enter valid Adhaar Number!!");
				}
				
			}while(studentAdhaarNumber <= 111111111111l || studentAdhaarNumber >= 999999999999l);
			
			sc.nextLine();
			System.out.println("Enter Date of Birth: ");
			System.out.println("Year (YYYY): ");
			int year = sc.nextInt();
			System.out.println("Month (MM): ");
			int month = sc.nextInt();
			System.out.println("Date (DD): ");
			int date = sc.nextInt();
			String studentDOB = date + "/" + month + "/" + year;
			
			sc.nextLine();
			System.out.println("Enter the address : ");
			String studentAddress = sc.nextLine();
			double studentFees = 0;
			do {
				System.out.println("Enter the fees submiteed by student : ");
				studentFees = sc.nextDouble();
				if(studentFees > Student.FEES) {
					System.out.println("Student fee is Rs." + Student.FEES + ". Please recheck the amount accepted by management! And enter the valid amount");
				}
				else if(studentFees < 0) {
					System.out.println("Enter valid amount!");
				}
				
			}while(studentFees > Student.FEES || studentFees < 0);
	
			student.put(studentId, new Student(studentId, studentName, studentAdhaarNumber, studentDOB, studentAddress, studentFees));
			capacity = student.size();
			
			getStudentDetails(studentId);
		}
		else {
			System.out.println("Only " + totalIntake + " students intake is allowed!!!");
		}
	}

    public boolean getStudentDetails(String studentId) {
    		
    	if(student.containsKey(studentId)) {
    		System.out.println("---------------------------------------------");
    		System.out.println("Student Profile : ");
    		System.out.println("---------------------------------------------");
    		System.out.println("Student Id        : " + student.get(studentId).getStudentId());    		
    		System.out.println("Student Name      : " + student.get(studentId).getStudentName());
    		System.out.println("Adhaar Number     : " + student.get(studentId).getStudentAdhaarNumber());
    		System.out.println("Date of Birth     : " + student.get(studentId).getStudentDOB());
    		System.out.println("Address           : " + student.get(studentId).getStudentAddress());
    		System.out.println("Fees              : " + student.get(studentId).getStudentFees());
    		System.out.println("---------------------------------------------");
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void updateStudentDetails() {
    	
    	System.out.println("1. Update Student Address.");
    	System.out.println("2. Update Student Fees ");
    	System.out.println("0. Exit");
    	System.out.println("Enter your choice : ");
    	
    	int choice = sc.nextInt();
    	if(choice == 0) {
    		return;
    	}
    	
		System.out.println("Enter student id: ");
		String studentId = sc.next();
		
		if(student.containsKey(studentId)) {
			
			if(choice == 1) {	
				sc.nextLine(); 
				System.out.println("Enter the New Address : ");
				String address = sc.nextLine();
				
				student.get(studentId).setStudentAddress(address);
				
				System.out.println("Updated Successfully");
				
				System.out.println("Student data after making changes : ");			
			}
			else if(choice == 2){
				
				System.out.println("Enter the fees : ");
				double fees = sc.nextDouble();
				
				fees += student.get(studentId).getStudentFees();
				System.out.println("Prevoisly paid amount : " + student.get(studentId).getStudentFees());
				System.out.println("Total fees paid till now : " + fees);
				
				if(Student.FEES >= fees) {
					student.get(studentId).setStudentFees(fees);
					if(Student.FEES == fees) {
						student.get(studentId).setFeesStatus("Paid");
					}
					else {
						System.out.println("Amount to be paid : " + (Student.FEES - student.get(studentId).getStudentFees()));
					}
				}
				else {
					System.out.println("The Fee is : " + Student.FEES + "\nYou are crediting extra money by : " + (fees - Student.FEES));
				}
			}
			getStudentDetails(studentId);	
		}
		else {
			System.out.println("Student Id is incorrect !");			
		}	
	}
		
	public void generateStudentReport() {
		if(student.size() != 0) {
			System.out.println("General Student details report : ");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");		
			System.out.println("|   Student Id   |         Student Name         | Student Adhaar Number | Student DOB |   Student Address   | Student fees status |");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");					
			for(Student s : student.values()) {
				if(s != null)
					System.out.printf("| %14s | %28s | %21d | %11s | %20s| %19s |\n",s.getStudentId(),s.getStudentName(), s.getStudentAdhaarNumber(), s.getStudentDOB(), s.getStudentAddress(), s.getFeesStatus());
				else
					break;
			}
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("No student is inserted yet");
		}
	}

	public void deleteStudentDetails(String studentId) {
		if(student.containsKey(studentId)) {
			student.remove(studentId);
			System.out.println("Student data is successfully deleted");
		}
		else {
			System.out.println("Student Id is incorrect");
		}
		capacity = student.size();
	}
		
	public void viewStudentDetails() {
		GovernmentOfficials governmentOfficial = GovernmentOfficials.getInstance();
		governmentOfficial.generateReport();
	}	
}

@SuppressWarnings("serial")
class InvalidAdhaarNumber extends ArithmeticException{

//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;

	public InvalidAdhaarNumber() {
		super("Invalid adhaar number! Provide a valid 12 digit adhaar number");
	}
	
}