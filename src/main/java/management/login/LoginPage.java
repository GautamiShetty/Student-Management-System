package management.login;

import java.util.Scanner;

import management.coordinators.GovernmentOfficials;
import management.coordinators.HealthInspector;
import management.coordinators.ScholarshipCoordinator;
import management.coordinators.StudentManager;

public class LoginPage{
	LoginCredentials admin = LoginCredentials.getInstance();
	Scanner sc = new Scanner(System.in);
	
	StudentManager studentManager;
	ScholarshipCoordinator scholarshipCoordinator;
	HealthInspector healthInspector;
	GovernmentOfficials governmentOfficials;
	
	public void loginPage() {
		
		boolean exit = false;
		
		while(!exit) {
			int choice;
			boolean check = true;
			boolean verify = true;	
			
			while(check&&!exit) {
				
				displayMenu();
				choice = getUserChoice();
				
				if(choice >=2 && choice <= 4) {	
					verify = checkCredentials(choice);				
				}
				
				if(verify || choice == 0) {
					switch(choice) {
					case 1:
					{
						displaySubMenu();
						int subChoice = getUserChoice();
						
						if(subChoice == 1 || subChoice == 2) {
							boolean verifySubChoices = checkSubCredentails(subChoice);
							if(verifySubChoices) {
								if(subChoice == 1) {
									studentManager = StudentManager.getInstance();
									studentManager = studentManager.controlPanel();							
								}
								else {
									admin.controlPanel();
								}							
							}							
						}
						else {
							System.out.println("Invalid Choice");
						}
					}
					break;
					case 2 :
					{
						scholarshipCoordinator = ScholarshipCoordinator.getInstance();
						scholarshipCoordinator = scholarshipCoordinator.controlPanel();
					}
					break;
					case 3:
					{
						healthInspector = HealthInspector.getInstance();
						healthInspector = healthInspector.controlPanel();
					}
					break;
					case 4:
					{
						governmentOfficials = GovernmentOfficials.getInstance();
						governmentOfficials = governmentOfficials.controlPanel();
					}
					break;
					case 0:
					{
						System.out.println("Are you sure you want to exit (Y/N)?");
						char ch = sc.next().charAt(0);
						if(ch == 'Y' || ch == 'y') {
							exit = true;
							System.out.println("You have successfully exited!");
							System.out.println("Thanks for visiting!");								
						}							
					}
					break;
					default:
						{
							System.out.println("Invalid choice!");
						}
					}
				}
				else {
					System.out.println("Invalid password or Username!!\n Try again");
				}				
			}			
		}
	}
	
	int getUserChoice() {
		while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
            System.out.print("Enter your choice: ");
        }
		return sc.nextInt();		
	}
	
	void displayMenu() {
		System.out.println("--------------------------------------");
		System.out.println("========Welcome to ABC college=========");	
		System.out.println("--------------------------------------");
		System.out.println("LoginPage as ");
		System.out.println("1. Admin");
		System.out.println("2. Scholarship Co-ordinator");
		System.out.println("3. Health Inspector");
		System.out.println("4. Government Official");
		System.out.println("0. To Exit");
		System.out.println("Enter your choice : ");
	}
	
	void displaySubMenu() {
		System.out.println("LoginPage as");
		System.out.println("1. Student Manager");
		System.out.println("2. LoginPage Manager");
		System.out.println("0. To Exit");
		System.out.println("Enter your choice : ");
	}
	
	boolean checkCredentials(int choice) {
	
			System.out.println("--------------------------------------");
			System.out.println("========Enter the credentials=========");	
			System.out.println("--------------------------------------");
		 	sc.nextLine();
			System.out.print("Enter username : ");
			String UserName = sc.nextLine();
			System.out.print("\nEnter password : ");
			String PassWord = sc.nextLine();
			switch(choice) {
	
				case 2: {
					if(admin.getScholarshipcoodUsername().equals(UserName) && admin.getScholarshipCoodPassword().equals(PassWord)) {
						return true;
					}
				}
				break;
				case 3: {
					if(admin.getHealthInspUsername().equals(UserName) && admin.getHealthInspPassword().equals(PassWord)) {
						return true;
					}
				}
				break;
				case 4: 
				{
	                if(admin.getGovofficialsUsername().equals(UserName)&& admin.getGovOfficialsPassword().equals(PassWord)) {
	                    return true;
	                }
	            }
				break;
				default : {
					System.out.println("Invalid choice");
				}
			}
			return false;
		}
	 
	boolean checkSubCredentails(int choice) {
		 	System.out.println("--------------------------------------");
			System.out.println("========Enter the credentials=========");	
			System.out.println("--------------------------------------");
		 	sc.nextLine();
			System.out.print("Enter username : ");
			String UserName = sc.nextLine();
			System.out.print("\nEnter password : ");
			String PassWord = sc.nextLine();
			switch(choice) {
				case 1 : {			
					if(admin.getStudentManagerUsername().equals(UserName) && admin.getStudentManagerPassword().equals(PassWord)) {
						return true;
					}
				}
				break;
				case 2: {
					if(admin.getLoginManagerUsername().equals(UserName) && admin.getLoginManagerPassword().equals(PassWord)) {
						return true;
					}
				}
				default : {
					System.out.println("Invalid choice");
					return false;
				}
			}
			System.out.println("Invalid username or password!");
			return false;
		 
	 }

}