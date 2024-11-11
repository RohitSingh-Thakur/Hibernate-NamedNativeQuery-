package namedNativeQueries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
			@NamedNativeQuery(
					name = "findByName",
					query = "SELECT * FROM Student WHERE stdName LIKE :char",
					resultClass = Student.class
					),
			
			@NamedNativeQuery(
					name = "getStudentMarksGreaterThan",
					query = "SELECT * FROM Student WHERE marks > :marks",
					resultClass = Student.class
					)})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stdId;
	private String stdName;
	private int marks;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String stdName, int marks) {
		this.stdName = stdName;
		this.marks = marks;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", marks=" + marks + "]";
	}

}
