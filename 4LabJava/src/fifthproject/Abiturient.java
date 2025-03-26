package fifthproject;

import java.util.Random;
import java.util.Date;
import java.util.ArrayList;

public class Abiturient {
	public static Random rand = new Random((new Date()).getTime());
	static final int MAX_A = 10;

	private String name = "";
	private int N = 0;
	private ArrayList<Integer> grades = new ArrayList<Integer>();

	public Abiturient() {
		N = 0;
		grades = null;
		name = "";
	}

	public Abiturient(int n) {
		this(n, MAX_A);
	}
	public Abiturient(String Name) {
		name = Name;
	}
	public Abiturient(String Name, int n) {
		name = Name;
		this.grades = new ArrayList<Integer>(n);
	}
	public Abiturient(int n, int max_val) {
		assert (n > 0);
		assert (max_val > 0);
		grades = new ArrayList<Integer>(n);
		N = n;
		for (int i = 0; i < N; i++) {
				grades.add(rand.nextInt(max_val));
		}
	}
	
	public int GetGrade(int i) {
		assert (N > 0);
		int n = grades.size();
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException();
		}
		return grades.get(i);
	}

	public void SetGrade(int i, int value) {
		assert (N > 0);
		int n = grades.size();
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException();
		}
		grades.set(i, value);
	}
	
	public void AddGrade(int value) {
		if(value < 0 || value > 10) {
			throw new IndexOutOfBoundsException();
		}
		grades.add(value);
	}
	
	public float GetAverage() {
		float sum = 0;
		for(int i = 0; i < grades.size(); i++) {
			sum += grades.get(i);
		}
		sum = sum / grades.size();
		return sum;
	}
	
	public void SetName(String Name) {
		name = Name;
	}
	public String GetName() {
		return name;
	}
}
