package management.coordinators;
import java.util.Scanner;

public class GovernmentOfficials {
	final int totalIntake = 5;
	Scanner sc = new Scanner(System.in);
	private GeneralReport report;
	
	private static final GovernmentOfficials governmentOfficial = new GovernmentOfficials();
	
    private GovernmentOfficials(){}

    public static GovernmentOfficials getInstance() {
        return governmentOfficial;
    }
		
    public GovernmentOfficials controlPanel() {
    	generateReport();
    	return null;
    }
 
	public void generateReport() {
		int choice;
		
		boolean check = true;
		while(check) {
			System.out.println("All reports: ");
			System.out.println("1. All Students general report");
			System.out.println("2. All Students health report");
			System.out.println("3. All students scholarship report");
			System.out.println("4. Individual student report");
			System.out.println("0. To exit");
			System.out.println("Enter the choice : ");
			choice = sc.nextInt();
			
			if(choice == 1) {
				report = StudentManager.getInstance();
				report.generateStudentReport();
			}
			else if(choice == 2) {
				report = HealthInspector.getInstance();
				report.generateStudentReport();
			}
			else if(choice == 3) {
				report = ScholarshipCoordinator.getInstance();
				report.generateStudentReport();
			}
			else if(choice == 4) {
				System.out.println("Enter student id : ");
				String studentId = sc.next();					
				report = StudentManager.getInstance();
				report.getStudentDetails(studentId);
				report = HealthInspector.getInstance();
				report.getStudentDetails(studentId);	
				report = ScholarshipCoordinator.getInstance();
				report.getStudentDetails(studentId);
			}
			else if(choice == 0) {
				System.out.println("Thank you for visiting!");
				check = false;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
	}

}