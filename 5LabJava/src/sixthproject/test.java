package sixthproject;

import java.util.Arrays;

public class test {
	static void sortAndPrint(Student[] pl) {
		// printout in table
		System.out.println("----- Sorted in natural order: ");
		Arrays.sort(pl);
		System.out.printf(Student.format());
		System.out.println();
		for (Student cnt : pl) {
			System.out.println(Student.format(cnt));
		}
	}

	static void sortAndPrint(Student[] pl, int sortBy) {
		// printout in table
		System.out.println("----- Sorted by: " + Student.getSortByName(sortBy));
		Arrays.sort(pl, Student.getComparator(sortBy));
		System.out.printf(Student.format());
		System.out.println();
		for (Student cnt : pl) {
			System.out.println(Student.format(cnt));
		}
	}

	public static void main(String[] args) {
		try {
			//Create array of contacts:
			Student[] pl = new Student[4];
			pl[0] = new Student("Joahn|37|woman|45.3|FPMI|2|11");
			pl[1] = new Student("Ann|23|woman|50|LDGV|3|10");
			pl[2] = new Student("Mary", "34", "woman", "36", "ASD");
			pl[3] = new Student("Empty|0000000|||||");
			//Test Comparable:
			sortAndPrint(pl);
			//Test Comparator:
			sortAndPrint(pl, 0);
			sortAndPrint(pl, 1);
			sortAndPrint(pl, 2);
			sortAndPrint(pl, 4);
			// reconstruct object from result of toString();
			Student c = pl[1];
			System.out.println("Source contact:\n\t" + Student.format(c));
			c = new Student(c.toString());
			System.out.println("Reconstructed contact:\n\t" + Student.format(c));
			// exception test:
			new Student("Test exception object");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
