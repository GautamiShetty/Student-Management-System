package management.templates;

public class Scholarship {
	final private String scholarshipId;
	final private String studentId;
	final private String scholarshipType;
	final private double scholarshipAmount;
	private String scholarshipStatus;
	
	public Scholarship(String scholarshipId, String studentId, String scholarshipType, double scholarshipAmount, String scholarshipStatus) {
		
		this.scholarshipId     = scholarshipId;
		this.studentId         = studentId;
		this.scholarshipType   = scholarshipType;
		this.scholarshipAmount = scholarshipAmount;
		this.scholarshipStatus = scholarshipStatus;
		
		System.out.println("Scholarship Details are successfully added!");
	}
	
	
//	private static String decodeToString(String studentId) {
//		byte[] decodedBytes = Base64.getDecoder().decode(studentId);
//        String decodedString = new String(decodedBytes);
////        System.out.println("Decoded: " + decodedString); 
//        return decodedString;
//	}

	public String getScholarshipId() {
		return scholarshipId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public String getScholarshipType() {
		return scholarshipType;
	}
	
	public double getScholarshipAmount() {
		return scholarshipAmount;
	}
	
	public String getScholarshipStatus() {
		return scholarshipStatus;
	}
	
	public void setScholarshipStatus(String scholarshipStatus) {
		this.scholarshipStatus = scholarshipStatus;
	}

}