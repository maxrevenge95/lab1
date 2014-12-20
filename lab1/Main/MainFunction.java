package Main;

import Student.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import Main.FileWorker;

public class MainFunction {
	protected static int mChoise = -1;
	protected static Student tempSt = new Student();
	protected static Scanner sc = new Scanner(System.in);

	public static void menuPrint() {
		System.out
				.println("1 - ������� �� �����\n2 - ��������\n"
						+ "3 - �������\n4 - ��������\n5 - ������� �� �����\n6 - �������� � ����\n7 - �����\n");
	}

	public static void print(List<Student> students) {
		if (students.size() == 0)
			System.out.println("��������� �����\n");
		else {
			Iterator<Student> it = students.iterator();
			int numb = 1;
			while (it.hasNext()) {
				System.out.print("������� � " + numb);
				tempSt = it.next();
				tempSt.outputStudent();
				numb++;
			}
		}
	}

	public static void remove(List<Student> students) {

		if (students.size() == 0)
			System.out.println("��������� �����\n");
		else {
			System.out.println("�������� ����� ������");
			int choise = sc.nextInt();
			if (choise >= students.size() || choise <= 0)
				System.out.println("����� ������ ���");
			else {
				students.remove(choise - 1);
				System.out.println("������ �������");
			}
		}
		sc.close();
	}

	public static void edit(List<Student> students) {

		if (students.size() == 0)
			System.out.println("��������� �����\n");
		else {
			tempSt = null;
			System.out.println("�������� ����� ������");
			int l = sc.nextInt();
			if (l > students.size() || l <= 0)
				System.out.println("����� ������ ���");
			else {
				tempSt = (Student) students.get(l - 1);
				tempSt.outputStudent();
				mChoise = -1;
				System.out
						.println("\n\n����� ���� �������������?\n"
								+ "1 - �����������\n2 - ���������\n3 - ��� ����������\n"
								+ "4 - �������\n5 - ��� ��������\n6 - ����� �������\n7 - ����\n\n");
				mChoise = sc.nextInt();
				switch (mChoise) {
				case 1:
					System.out.println("�����������:");
					tempSt.setUniversityName(sc.next());
					break;
				case 2:
					System.out.println("���������");
					tempSt.setFakultetName(sc.next());
					break;
				case 3:
					System.out.println("��� ����������");
					tempSt.setCodeFakultet(sc.nextInt());
					break;
				case 4:
					System.out.println("�������");
					tempSt.setFIO(sc.next());
					break;
				case 5:
					System.out.println("��� ��������");
					tempSt.setBornYear(sc.nextInt());
					break;
				case 6:
					System.out.println("����� �������");
					tempSt.setNumberExamBook(sc.nextLong());
					break;
				case 7:
					System.out.println("����");
					tempSt.setKurs(sc.nextInt());
					break;
				case 0:
					System.exit(0);
					break;
				}
				System.out.println("������ ���������������");
			}
		}
	}

	public static void add(List<Student> students) {
		Student student = new Student();
		student = student.inputStudent();
		students.add(student);
		System.out.println("������ ���������");
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		List<Student> students = new ArrayList<Student>();
		System.out.println("Hello\nchoise please...");
		do {
			menuPrint();
			mChoise = sc.nextInt();
			switch (mChoise) {
			case 1:
				print(students);
				break;
			case 2:
				add(students);
				break;
			case 3:
				remove(students);
				break;
			case 4:
				edit(students);
				break;
			case 5:
				students.removeAll(students);
				students = FileWorker.reader();
				break;
			case 6:
				if (students.size() == 0)
					System.out.println("��������� �����\n");
				else
					FileWorker.writer(students);
				break;
			case 7:
				System.exit(0);
				break;
			default:
				break;

			}
		} while (true);

	}

}
