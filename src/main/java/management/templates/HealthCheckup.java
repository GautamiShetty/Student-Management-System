package management.templates;

public class HealthCheckup {
	
	private String inspectorId;
	private String studentId;
	private String inspectionType;
	private String inspectionDate;
	private String inspectionResult;
	
	public HealthCheckup(String studentId,String inspectorId, String inspectionType, String inspectionDate, String inspectionResult) {
		super();
		this.studentId = studentId;
		this.inspectorId = inspectorId;
		this.inspectionType = inspectionType;
		this.inspectionDate = inspectionDate;
		this.inspectionResult = inspectionResult;
		
		System.out.println("Health Details are successfully added!");
	}

	public String getInspectorId() {
		return inspectorId;
	}

	public void setInspectorId(String inspectorId) {
		this.inspectorId = inspectorId;
	}
	
	public String getInspectionId() {
		return inspectorId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getInspectionDate() {
		return inspectionDate;
	}
	
	public String getInspectionResult() {
		return inspectionResult;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public String setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
		return inspectionType;
	}	
	
	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	
	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}
}