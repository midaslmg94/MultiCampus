package pro.member.model;

public class MemberVO {
  //DB테이블(member)의 레코드(행row)를 표현하는 클래스 
	private int no;
	private String name;
	private int age;
	private String job;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(int no, String name, int age, String job) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
  

}




