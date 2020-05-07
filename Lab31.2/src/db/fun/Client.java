package db.fun;

public class Client {

	public static void main(String[] args) {
		TrainingDAO data = new TrainingDAO();
		
		data.getAllEmps().forEach(System.out::println);
		System.out.println("//////////////////");
		System.out.println(data.getEmployeeByIdPrepState(3));
		System.out.println("//////////////////");
		System.out.println(data.getEmployeeByIdStream(4));

	}

}
