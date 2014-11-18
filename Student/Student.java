package Student;

import Fakultet.*;
import java.io.*;
import java.util.*;

public class Student extends Fakultet implements SGStudent, Serializable {
	protected String FIO;
	protected int bornYear;
	protected int kurs;
	protected long numberExamBook;
	protected static Scanner sc = new Scanner(System.in);

	public Student() {
		universityName = "DefaultNameUniversity";
		fakultetName = "DefaultNameFakultet";
		codeFakultet = 1;
		FIO = "DefaultNameStudent";
		bornYear = 1990;
		kurs = 1;
		numberExamBook = 272303;
	}

	@Override
	public void setStudent(String nameU, String nameF, int codeF, String nameS,
			int bYear, int kurs, long numbExB) {
		setFakultet(nameU, nameF, codeF);
		FIO = nameS;
		bornYear = bYear;
		this.kurs = kurs;
		numberExamBook = numbExB;
	}

	@Override
	public Student getStudent() {
		return this;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String fIO) {
		FIO = fIO;
	}

	public int getBornYear() {
		return bornYear;
	}

	public void setBornYear(int bornYear) {
		this.bornYear = bornYear;
	}

	public int getKurs() {
		return kurs;
	}

	public void setKurs(int kurs) {
		this.kurs = kurs;
	}

	public long getNumberExamBook() {
		return numberExamBook;
	}

	public void setNumberExamBook(long numberExamBook) {
		this.numberExamBook = numberExamBook;
	}

	@Override
	public Student inputStudent() {
		System.out.print("Университет: ");
		this.universityName = sc.next();
		System.out.print("Факультет: ");
		this.fakultetName = sc.next();
		System.out.print("Код факультета: ");
		this.codeFakultet = sc.nextInt();
		System.out.print("ФИО студента: ");
		this.FIO = sc.next();
		System.out.print("Год рождения: ");
		this.bornYear = sc.nextInt();
		System.out.print("Курс: ");
		this.kurs = sc.nextInt();
		System.out.print("Номер зачетки: ");
		this.numberExamBook = sc.nextLong();
		return this;
	}

	@Override
	public void outputStudent() {
		System.out.print("\nУниверситет:" + this.getUniversityName()
				+ "\nФакультет:" + this.getFakultetName() + "\nкод факультета:"
				+ this.getCodeFakultet() + "\nФИО:" + this.getFIO()
				+ "\nГод рождения:" + this.getBornYear() + "\nКурс:"
				+ this.getKurs() + "\nНомер зачетки:"
				+ this.getNumberExamBook() + "\n\n");
	}

}
