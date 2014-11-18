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
				.println("1 - вывести на экран\n2 - добавить\n"
						+ "3 - удалить\n4 - изменить\n5 - считать из файла\n6 - записать в файл\n7 - выход\n");
	}

	public static void print(List<Student> students) {
		if (students.size() == 0)
			System.out.println("коллекция пуста\n");
		else {
			Iterator<Student> it = students.iterator();
			int numb = 1;
			while (it.hasNext()) {
				System.out.print("Студент № " + numb);
				tempSt = it.next();
				tempSt.outputStudent();
				numb++;
			}
		}
	}

	public static void remove(List<Student> students) {

		if (students.size() == 0)
			System.out.println("коллекция пуста\n");
		else {
			System.out.println("выберите номер записи");
			int choise = sc.nextInt();
			if (choise >= students.size() || choise <= 0)
				System.out.println("такой записи нет");
			else {
				students.remove(choise - 1);
				System.out.println("запись удалена");
			}
		}
		sc.close();
	}

	public static void edit(List<Student> students) {

		if (students.size() == 0)
			System.out.println("коллекция пуста\n");
		else {
			tempSt = null;
			System.out.println("выберите номер записи");
			int l = sc.nextInt();
			if (l > students.size() || l <= 0)
				System.out.println("такой записи нет");
			else {
				tempSt = (Student) students.get(l - 1);
				tempSt.outputStudent();
				mChoise = -1;
				System.out
						.println("\n\nкакое поле редактировать?\n"
								+ "1 - университет\n2 - факультет\n3 - код факультета\n"
								+ "4 - фамилия\n5 - год рождения\n6 - номер зачетки\n7 - курс\n\n");
				mChoise = sc.nextInt();
				switch (mChoise) {
				case 1:
					System.out.println("Университет:");
					tempSt.setUniversityName(sc.next());
					break;
				case 2:
					System.out.println("Факультет");
					tempSt.setFakultetName(sc.next());
					break;
				case 3:
					System.out.println("Код Факультета");
					tempSt.setCodeFakultet(sc.nextInt());
					break;
				case 4:
					System.out.println("Фамилия");
					tempSt.setFIO(sc.next());
					break;
				case 5:
					System.out.println("Год Рождения");
					tempSt.setBornYear(sc.nextInt());
					break;
				case 6:
					System.out.println("Номер зачетки");
					tempSt.setNumberExamBook(sc.nextLong());
					break;
				case 7:
					System.out.println("Курс");
					tempSt.setKurs(sc.nextInt());
					break;
				case 0:
					System.exit(0);
					break;
				}
				System.out.println("запись отредактирована");
			}
		}
	}

	public static void add(List<Student> students) {
		Student student = new Student();
		student = student.inputStudent();
		students.add(student);
		System.out.println("запись добавлена");
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
					System.out.println("коллекция пуста\n");
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
