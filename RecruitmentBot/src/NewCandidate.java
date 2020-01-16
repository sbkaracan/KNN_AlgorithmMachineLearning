
public class NewCandidate {
	private double social,alg,gpa, age;
	
	public NewCandidate(double social,double alg,double gpa,double age) {//constructor of a candidate which we use in the project.
		this.social = social;
		this.alg = alg;
		this.gpa = gpa;
		this.age = age;
	}
	
	public double getSocial() {
		return social;
	}

	public void setSocial(double social) {
		this.social = social;
	}

	public double getAlg() {
		return alg;
	}

	public void setAlg(double alg) {
		this.alg = alg;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	
	
	@Override
	public String toString() {
		return "NewCandidate [social=" + social + ", alg=" + alg + ", gpa=" + gpa + ", age=" + age + "]";
	}
	
	
	
}