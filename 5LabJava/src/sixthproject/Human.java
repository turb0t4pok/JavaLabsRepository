package sixthproject;

import sixthproject.Student.ArgException;

public class Human {
	String name;
	int age;
	String sex;
	float weight;

	public Human(String name, int age, String sex, float weight) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
}
	public Human(String str) {}
	public Human(String... args) throws ArgException {}
	public void SetName(String name) {
		this.name = name;
}
	public void SetAge(int age) {
		this.age = age;
}
	public void SetWeight(float weight) {
		this.weight = weight;
}
}
