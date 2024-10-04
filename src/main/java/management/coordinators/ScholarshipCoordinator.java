package management.coordinators;
import java.util.LinkedHashMap;

import management.templates.Scholarship;
import management.templates.StudentIdAccess;

public class ScholarshipCoordinator extends Coordinator  implements GeneralReport {
	
	private LinkedHashMap<String, Scholarship> scholarship = new LinkedHashMap<String, Scholarship>();
	StudentIdAccess Id = StudentManager.getInstance();
		
	private static final ScholarshipCoordinator scholarshipCoordinator = new ScholarshipCoordinator();
	
    private ScholarshipCoordinator(){}

    public static ScholarshipCoordinator getInstance() {
        return scholarshipCoordinator;
    }    

    public ScholarshipCoordinator controlPanel() {
    	Boolean check = true;    	
    	while(check) {
    		System.out.println("\n---------------------------------------------");
    		System.out.println("Scholarship Coordinator Control Panel : ");
    		System.out.println("---------------------------------------------");
    		System.out.println("1. Add Scholarship Details");
    		System.out.println("2. Update Scholarship Status");
    		System.out.println("3. Get Scholarship Details");
    		System.out.println("4. Generate Student Scholarship Report");
    		System.out.println("5. Delete Scholarship Details");
    		System.out.println("6. Track Student Scholarship Status");
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
		    			
		    			if(scholarship.containsKey(studentId))
		    				getStudentDetails(studentId);
		    			else 
		    				System.out.println("Entered Student Id details does not exist!");
		    				
		    		}
					break;
	    		case 4:
		    		{
		    			viewStudentDetails();
		    		}
					break;
	    		case 5:
		    		{
		    			System.out.println("Enter Student Id: ");
		    			String studentId = sc.next();
		    			deleteStudentDetails(studentId);
		    		}
					break;
	    		case 6:
		    		{
		    			System.out.println("Enter Student Id: ");
		    			String studentId = sc.next();
		    			trackStudentStatus(studentId);
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
	
	public void addStudentDetails(){
		if(scholarship.size() < totalIntake) {			
			System.out.println("---------------------------------------------");
			System.out.println("Enter Scholarship Details :");
			System.out.println("---------------------------------------------");
			
			sc.nextLine();
			System.out.println("Enter Scholarship Id :");
			String scholarshipId = sc.nextLine();
			
			System.out.println("Enter the Student Id :");			
			String studentId = sc.next();
			
			if(!Id.containsStudentId(studentId)) {
				System.out.println("Entered Student Id does not exist!");
				return;
			}
			
			sc.nextLine();
			System.out.println("Enter the Scholarship type :");
			String scholarshipType = sc.nextLine();
			
			System.out.println("Enter Scholarship Amount :");
			double scholarshipAmount = sc.nextDouble();			
			
			sc.nextLine();
			System.out.println("Enter Scholarship Status :");
			String scholarshipStatus = sc.nextLine();
			scholarship.put(studentId, new Scholarship(scholarshipId, studentId, scholarshipType, scholarshipAmount, scholarshipStatus));			
			getStudentDetails(studentId);
			
		}
		else {
			System.out.println("No more students are allowed!!!");
		}
		
	}
	
	public boolean getStudentDetails(String studentId) {		
		
		if(scholarship.containsKey(studentId)) {
			System.out.println("---------------------------------------------");		
			System.out.println("Scholarship Details : ");		
			System.out.println("---------------------------------------------");			
			System.out.println("Scholarship Id         : " + scholarship.get(studentId).getScholarshipId());		
			System.out.println("Student Id             : " + scholarship.get(studentId).getStudentId());			
			System.out.println("Scholarship Type       : " +  scholarship.get(studentId).getScholarshipType());			
			System.out.println("Scholarship Amount     : " +  scholarship.get(studentId).getScholarshipAmount());			
			System.out.println("Scholarship Status     : " +  scholarship.get(studentId).getScholarshipStatus());
			System.out.println("---------------------------------------------");
			return true;
		}
		else{			
			return false;			
		}
		
	}
	
	public void updateStudentDetails() {
		System.out.println("Enter student id: ");
		String studentId = sc.next();
		
		if(scholarship.containsKey(studentId)) {
			sc.nextLine();
			System.out.println("Enter the status(pending/receieved) :");
			String scholarshipStatus = sc.nextLine();
			
			scholarship.get(studentId).setScholarshipStatus(scholarshipStatus);
			
			System.out.println("Status changed Successfully");			
			getStudentDetails(studentId);
    	}
		else {
			System.out.println("Entered Student Id does not exist!");
		}	
	}
		
	public void generateStudentReport() {
		System.out.println("Student Scholarship details report : ");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");		
			System.out.println(" Student Id | Scholarship Id |            Scholarship Type                  | Scholarship Amount | Scholarship Status |  ");// 3 12 30 23 13 31
			System.out.println("----------------------------------------------------------------------------------------------------------------------");					
			for(Scholarship s : scholarship.values()) {
				if(s != null)
					
					System.out.printf(" %10s | %14s | %44s | %18.2f | %18s|\n",s.getStudentId(), s.getScholarshipId(), s.getScholarshipType(), s.getScholarshipAmount(), s.getScholarshipStatus());
				else
					break;
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------------");		
	}
	
	public void deleteStudentDetails(String studentId) {
		if(scholarship.containsKey(studentId)) {
			scholarship.remove(studentId);
			System.out.println("Scholarship data of " + studentId+ " is successfully deleted");
    	}
		else {
			System.out.println("Entered Student Id does not exist!");
		}
	}

	public void trackStudentStatus(String studentId) {
		System.out.println("Scholarship Status : " + scholarship.get(studentId).getScholarshipStatus());
	}
	
	public void viewStudentDetails() {
		boolean check = true;
		while(check) 
		{
			System.out.println("1. View Individual Student's Scholarship data");
			System.out.println("2. View all Student's Scholarship data");
			System.out.println("0. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				GeneralReport report = ScholarshipCoordinator.getInstance();
				System.out.println("Enter student Id : ");
				String studentId = sc.next();
				if(scholarship.containsKey(studentId)) {
					report.getStudentDetails(studentId);					
				}
				else {
		    		System.out.println("Student Id is incorrect");
				}
			}
			else if(choice == 2) {
				GeneralReport report = ScholarshipCoordinator.getInstance();
				report.generateStudentReport();;
			}
			else if(choice == 0) {
				check = false;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
	}
}