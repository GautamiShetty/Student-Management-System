package management.coordinators;

import java.util.LinkedHashMap;
import management.templates.HealthCheckup;
import management.templates.StudentIdAccess;

public class HealthInspector extends Coordinator  implements GeneralReport, StudentIdAccess{
	
	private LinkedHashMap<String, HealthCheckup> healthCheckup = new LinkedHashMap<String, HealthCheckup>();
	public int capacity = 0;	
	StudentIdAccess Id = StudentManager.getInstance();
	
	private static final HealthInspector healthInspector = new HealthInspector();	
    private HealthInspector(){}
    public static HealthInspector getInstance() {
        return healthInspector;
    }
    
    @Override
    public boolean containsStudentId(String studentId) {
    	return Id.containsStudentId(studentId);
    }
    
    public HealthInspector controlPanel() {
    	Boolean check = true;    	
    	while(check) {
    		System.out.println("\n---------------------------------------------");
    		System.out.println("Health Inspector Control Panel : ");
    		System.out.println("---------------------------------------------");

    		System.out.println("1. Add Medical Details");
    		System.out.println("2. Update Medical Status");
    		System.out.println("3. Get Medical Details");
    		System.out.println("4. Generate Student Medical Report");
    		System.out.println("5. Delete Medical Details");
    		System.out.println("0. Log out");
    		System.out.println("---------------------------------------------");
    		System.out.println("Enter your choice : ");
    		int choice = sc.nextInt();
    		
    		switch(choice) 
    		{
	    		case 1: 
	    			addStudentDetails();
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
		    					    			
		    			if(healthCheckup.containsKey(studentId)) {
		    				getStudentDetails(studentId);		    				
		    			}
		    			else {
		    				System.out.println("Invalid student Id!");
		    			}
		    		}
					break;
	    		case 4:
		    		{
		    			viewStudentDetails();		    		
					}
					break;
	    		case 5:
		    		{
		    			System.out.println("Enter student id: ");
		    			String studentId = sc.next();
		    			deleteStudentDetails(studentId);
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
		if(capacity < totalIntake) {			
			System.out.println("---------------------------------------------");
			System.out.println("Enter Medical Details :");
			System.out.println("---------------------------------------------");
			
			System.out.println("Enter Student id: ");
			String studentId = sc.next();
					    			
			if(!Id.containsStudentId(studentId)){
				System.out.println("Entered Student Id does not exist!");
				return;
			}
			
			sc.nextLine();
			System.out.println("Enter Inspection Id :");
			String inspectionId = sc.nextLine();
			
			System.out.println("Enter the Inspection Type: ");
			String inspectionType = sc.nextLine();
			
			System.out.println("Enter the Inspection date (DD/MM/YY): ");
			System.out.println("Date: ");
			int date = sc.nextInt();
			System.out.println("Month: ");
			int month = sc.nextInt();
			System.out.println("Year: ");
			int year = sc.nextInt();
			String inspectionDate = date + "/" + month + "/" + year;
			
			System.out.println("Enter Inspection Result: ");
			String inspectionResult = sc.nextLine();
			
			healthCheckup.put(studentId,new HealthCheckup (studentId, inspectionId, inspectionType, inspectionDate, inspectionResult));
			
		}
		else {
			System.out.println("No more students are allowed!!!");
		}
		
	}
		
	public boolean getStudentDetails(String studentId) {		
		
		if(healthCheckup.containsKey(studentId)) {
			System.out.println("---------------------------------------------");	
			System.out.println("Health details ");
			System.out.println("---------------------------------------------");	
			System.out.println("Inspection Id              : " + healthCheckup.get(studentId).getInspectionId());
			System.out.println("Student Id                 : " + healthCheckup.get(studentId).getStudentId());
			System.out.println("Inspection type            : " + healthCheckup.get(studentId).getInspectionType());
			System.out.println("Inspection date (DD/MM/YY) : " + healthCheckup.get(studentId).getInspectionDate());
			System.out.println("Inspection Result          : " + healthCheckup.get(studentId).getInspectionResult());			
			System.out.println("---------------------------------------------");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updateStudentDetails() {
		System.out.println("Enter student id : ");
		String studentId = sc.next();
		if(healthCheckup.containsKey(studentId)) {
			
			boolean check = true;
			int choice = 1;
			
			while(check) {
				
				System.out.println("Which data do you want to update?");
				System.out.println("1. Inspection ID");
				System.out.println("2. Student ID");
				System.out.println("3. Inspection type");
				System.out.println("4. Inspection Result");
				System.out.println("0. Exit");
				System.out.println("Enter the choice : ");
				choice = sc.nextInt();
				
				if(choice == 1) {
					sc.nextLine();
					System.out.println("Enter the new Inspection Id : ");
					String inspectionId = sc.nextLine();
					healthCheckup.get(studentId).setInspectorId(inspectionId);
					
				}
				else if(choice == 2) {
					healthCheckup.get(studentId).setStudentId(studentId);
				}
				else if(choice == 3) {
					sc.nextLine();
					System.out.println("Enter the Inspection type : ");
					String inspectionType = sc.nextLine();
					healthCheckup.get(studentId).setInspectionType(inspectionType);
				}
				else if(choice == 0) {
					System.out.println("You have not changed anything");
					check = false;
				}
				else {
					System.out.println("Invalid choice");
				}
			}
			if(choice != 0) {
				if(!getStudentDetails(studentId)) {
					System.out.println("Invalid Student Details");
				}
			}
		}
		else {
			System.out.println("Student Id is incorrect");
		}		
	}

	public void generateStudentReport() {
		System.out.println("Student health details report : ");
		System.out.println("------------------------------------------------------------------------------------------");		
		System.out.println(" Student Id | Inspection Id |  Inspection Date   |  Inspection Type  | Inspection Result |");
		System.out.println("------------------------------------------------------------------------------------------");					
		for(HealthCheckup h : healthCheckup.values()) {
			if(h != null)
				System.out.printf(" %10s | %13s | %18s | %17s | %17s |\n",h.getStudentId(), h.getInspectionId(), h.getInspectionDate(), h.getInspectionType(), h.getInspectionResult());
			else
				break;
		}
		System.out.println("------------------------------------------------------------------------------------------");		

	}

	public void deleteStudentDetails(String studentId) {
		if(healthCheckup.containsKey(studentId)) {
			healthCheckup.remove(studentId);
			System.out.println("Health related data of " + studentId+ " is successfully deleted");	
		}
		else {
			System.out.println("Student Id is incorrect");
		}
	}
	
	public void viewStudentDetails() {
		boolean check = true;
		while(check) 
		{
			System.out.println("1. View Individual Student's Medical data");
			System.out.println("2. View all Student's Medical data");
			System.out.println("0. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				GeneralReport report = HealthInspector.getInstance();
				System.out.println("Enter student id: ");
    			String studentId = sc.next();
    					    			
    			if(healthCheckup.containsKey(studentId)) {
					report.getStudentDetails(studentId);					
				}
				else {
		    		System.out.println("Student Id is incorrect");
				}
			}
			else if(choice == 2) {
				GeneralReport report = HealthInspector.getInstance();
				report.generateStudentReport();;
			}
			else if(choice == 0) {
				check = false;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
		System.out.println("Press enter to proceed...");
		sc.nextLine();
	}

}