package db.fun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TrainingDAO {

	private List<Employee> emps = new ArrayList<>();

	TrainingDAO() {
		buildList();
	}

	private void buildList() {
		try {
			Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/trainingDb");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");

			while (rs.next()) {
				long id = rs.getLong("EMPID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				long deptId = rs.getInt("DEPTID");
				long credits = rs.getInt("CREDITS");
				emps.add(new Employee(id, firstName, lastName, deptId, credits));
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployeeByIdPrepState(int idNum) {
		String sql = "select * from employee where EMPID = ?";
		Employee emp = null;
		try {
			Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/trainingDb");
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, idNum);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new Employee(rs.getLong("EMPID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getInt("DEPTID"), rs.getInt("CREDITS"));
			}
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	public List<Employee> getAllEmps() {
		return Collections.unmodifiableList(emps);
	}

	public Employee getEmployeeByIdStream(long idNum) {
		Optional<Employee> emp1 = emps.stream().filter(e -> e.getId() == idNum).findFirst();
		if (emp1.isPresent() && emp1 != null) {
			return emp1.get();
		} else {
			return null;
		}
	}

}
