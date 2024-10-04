package management.login;

import java.util.Scanner;

class LoginCredentials {
	
	Scanner sc = new Scanner(System.in);
	
	private static final LoginCredentials credential= new LoginCredentials();	
	private LoginCredentials() {}	
	public static LoginCredentials getInstance() {
		return credential;
	}
	
	private final String studentManagerUsername = "123";
	private String studentManagerPassword = "123";
	
	private final String LoginManagerUsername = "123";
	private String LoginManagerPassword = "123";
	
	private final String scholarshipCoodUsername = "123";
	private String scholarshipCoodPassword = "123";
	
	private final String healthInspUsername = "123";
	private String healthInspPassword = "123";
	
	private final String govOfficialsUsername = "123";
	private String govOfficialsPassword = "123";
	
	public String getStudentManagerUsername() {
		return studentManagerUsername;
	}	
	
	public String getStudentManagerPassword() {
		return studentManagerPassword;
	}	
	
	public String getLoginManagerUsername() {
		return LoginManagerUsername;
	}	
	
	public String getLoginManagerPassword() {
		return LoginManagerPassword;
	}	
	
	public String getScholarshipcoodUsername() {
		return scholarshipCoodUsername;
	}
	
	public String getScholarshipCoodPassword() {
		return scholarshipCoodPassword;
	}
	
	public String getHealthInspUsername() {
		return healthInspUsername;
	}
	
	public String getHealthInspPassword() {
		return healthInspPassword;
	}
	
	public String getGovofficialsUsername() {
		return govOfficialsUsername;
	}
	
	public String getGovOfficialsPassword() {
		return govOfficialsPassword;
	}

	
	public void setScholarshipCoodPassword(String scholarshipCoodPassword) {
		this.scholarshipCoodPassword = scholarshipCoodPassword;
	}

	public void setHealthInspPassword(String healthInspPassword) {
		this.healthInspPassword = healthInspPassword;
	}

	public void setGovOfficialsPassword(String govOfficialsPassword) {
		this.govOfficialsPassword = govOfficialsPassword;
	}
	
	public void setStudentManagerPassword(String studentManagerPassword) {
		this.studentManagerPassword = studentManagerPassword;
	}
	
	public void setLoginManagerPassword(String loginManagerPassword) {
		LoginManagerPassword = loginManagerPassword;
	}
	
	LoginCredentials controlPanel() {
		Boolean check = true;    	
    	while(check) {
			System.out.println("\n---------------------------------------------");
    		System.out.println("LoginPage Manager Control Panel : ");
			System.out.println("---------------------------------------------");
    		System.out.println("1. Set Student Manager Password");
    		System.out.println("2. Set Scholarship Co-ordinator Password");
    		System.out.println("3. Set Health Inspector Password");
    		System.out.println("4. Set Government Officials Password");
    		System.out.println("0. Log out");
			System.out.println("---------------------------------------------");
    		System.out.println("Enter your choice : ");
    		int choice = sc.nextInt();
    		String password = "";
    		
    		if(choice != 0) {
    			System.out.println("Enter new password : ");
    			password = sc.next();
    		}
    		
    		switch(choice) 
    		{
	    		case 1:
		    		{
						setStudentManagerPassword(password);
					}
				break;	    		
	    		case 2:
		    		{		    			
		    			setScholarshipCoodPassword(password);	    			
		    		}
					break;
	    		case 3:
		    		{		    			
		    			setHealthInspPassword(password);
		    		}
					break;
	    		case 4:
		    		{
		    			setGovOfficialsPassword(password);
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
}