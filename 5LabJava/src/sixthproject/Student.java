package sixthproject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Student extends Human implements Comparable<Student>, Iterable<String>{
	
	public static class ArgException extends Exception {
		private static final long serialVersionUID = 1L;

		ArgException(String arg) {
			super("Invalid argument: " + arg);
		}
	}
	
	String faculty;
	int course;
	int group;
	public static final String[] names = { 
			"*Name", 
			"*Age", 
			"Sex",
			"Weight", 
			"Faculty", 
			"Course", 
			"Group" 
			};
	public static String[] formatStr = { 
			"%-9s", //
			"%-9s", //
			"%-9s", //
			"%-9s", //
			"%-17s", //
			"%-17s", //
			"%-9s" //
			};
	
	public static String getSortByName(int sortBy) {
		return Student.names[sortBy];
	}
	
	public Student(String name, int age, String sex, float weight, String faculty, int course, int group) {
		super(name, age, sex, weight);
		this.faculty = faculty;
		this.course = course;
		this.group = group;
	}
	
	public static Comparator<Student> getComparator(final int sortBy) {
		if (sortBy >= 7 || sortBy < 0) {
			throw new IndexOutOfBoundsException();
		}
		return new Comparator<Student>() {
			@Override
			public int compare(Student c0, Student c1) {
				return c0.areas[sortBy].compareTo(c1.areas[sortBy]);
			}
		};
	}
	
	protected boolean validName(String str) {
		return str != null && str.length() > 0;
	}

	protected boolean validAge(String str) {
		int number = Integer.parseInt(str);
		return number < 120 && number  > 0;
	}

	protected boolean validSex(String str) {
		return str == "woman" || str == "man";
	}

	protected boolean validWeight(String str) {
		float number = Float.parseFloat(str);
		return number > 0 && number < 400;
	}

	protected boolean validFaculty(String str) {
		return str != null;
	}

	protected boolean validGroup(String str) {
		int number = Integer.parseInt(str);
		return number > 0 && number <= 15;
	}
	
	protected boolean validCourse(String str) {
		int number = Integer.parseInt(str);
		return number > 0 && number <= 5;
	}
	
	private String[] areas = null;
	public int length() {
		return areas.length;
	}
	public String getArea(int idx) {
		if (idx >= length() || idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		return areas[idx];
	}
	public void setArea(int idx, String value) throws ArgException {
		if (idx >= length() || idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		if ((idx == 0 && validName(value) == false)
				|| (idx == 1 && validAge(value) == false)
				|| (idx == 2 && validSex(value) == false)
				|| (idx == 3 && validWeight(value) == false)
				|| (idx == 4 && validFaculty(value) == false)
				|| (idx == 5 && validCourse(value) == false)
				|| (idx == 6 && validGroup(value) == false)) {
			throw new ArgException(value);
		}
		areas[idx] = value;
	}
	
	@Override
	public Iterator<String> iterator() {
		//Iterator<String>
		return new Iterator<String>() {
			//private Contact contact = thisContact;
			private int iterator_idx = -1;

			@Override
			public boolean hasNext() {
				return iterator_idx < (areas.length - 1);
			}

			@Override
			public String next() {
				if (iterator_idx < (areas.length - 1)) {
					return areas[++iterator_idx];
				} 
				throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Override
	public int compareTo(Student cy) {
		return Student.format(this).compareTo(Student.format(cy));
	}

	// toString
	@Override
	public String toString() {
		if (areas == null) {
			return " | | | | | | ";
		}
		String res = areas[0];
		for (int i = 1; i < areas.length; i++) {
			res += "|" + areas[i];
		}
		return res;
	}

	// constructors:
	// public Contact() {}
	private void setup(String[] args) throws ArgException {
		if (args == null) {
			throw new ArgException("null pointer passed for args");
		}
		if (args.length < 2 || args.length > 7) {
			throw new ArgException(Arrays.toString(args));
		}
		areas = new String[7];
		int i = 0;
		for (; i < args.length; i++) {
			setArea(i, args[i]);
		}
		while (i < 7) {
			areas[i++] = "";
		}
	}

	public Student(String str) throws ArgException {
		super(str);
		if (str == null) {
			throw new ArgException("null pointer passed for str");
		}
		setup(str.split("\\|"));
	}

	public Student(String... args) throws ArgException {
		super(args);
		setup(args);
	}

	private static String format(Iterable<String> what) {
		String result = "";
		int idx = 0;
		for (String str : what) {
			result += String.format(formatStr[idx++], str);
		}
		return result;
	}

	public static String format() {
		return Student.format(Arrays.asList(Student.names));
	}

	public static String format(Student cn) {
		return Student.format(((Iterable<String>) cn));
	}
}
