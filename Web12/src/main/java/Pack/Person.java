package Pack;

public class Person {
	String name;
	String age;
	public Person() {
		System.out.println("��������");
	}
	public String getName() {
		System.out.println("�Լ���");
		System.out.println(name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		System.out.println(age);
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
