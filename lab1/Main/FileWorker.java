package Main;

import Student.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWorker {
	protected static ObjectOutputStream out;
	protected static ObjectInputStream in;
	protected static String nameFile = "file_info_students.txt";

	public static String getNameFile() {
		return nameFile;
	}

	public static void writer(List<Student> students)
			throws FileNotFoundException, IOException {
		out = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(nameFile)));
		out.writeObject(students);
		out.close();
	}

	public static List<Student> reader() throws FileNotFoundException,
			IOException, ClassNotFoundException {
		in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
				nameFile)));
		List<Student> students = (List<Student>) in.readObject();
		in.close();
		return students;
	}
}
