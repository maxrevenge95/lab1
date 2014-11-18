package Student;

public interface SGStudent {
	public void setStudent(String nameU, String nameF, int codeF, String nameS,
			int bYear, int kurs, long numbExB);

	public Student getStudent();

	public Student inputStudent();

	public void outputStudent();
}
