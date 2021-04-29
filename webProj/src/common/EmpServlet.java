package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empList.do")
public class EmpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// super.doGet(req, resp);
		PrintWriter out = resp.getWriter();

		String dept = req.getParameter("dept");

		EmpDAO dao = new EmpDAO();
		List<Employee> list = null;

		if (dept == null) {
			list = dao.getEmpList();
		} else {
			list = dao.getEmpByDept(dept);
		}

		// [{"empId":"?", "fName":"?" , "lName": "?" }, ...] \"\" 문장안에서 따옴표만들기위해씀
		String jsonData = "[";
		int cnt = 0;
		for (Employee emp : list) {
			jsonData += "{\"empId\":\"" + emp.getEmployeeId() //
					+ "\",\"fName\":\"" + emp.getFirstName() //
					+ "\",\"lName\":\"" + emp.getLastName() //
					+ "\",\"email\":\"" + emp.getEmail() //
					+ "\",\"salary\":\"" + emp.getSalary() //
					+ "\",\"jobId\":\"" + emp.getJobId() //
					+ "\",\"hdate\":\"" + emp.getHireDate() //
					+ "\"}";
			if (++cnt == list.size()) {
				continue;
			}
			jsonData += ",";
		}
		jsonData += "]";

		out.println(jsonData);

	}

	@Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	      super.doPost(req, resp);
	      String lastName = req.getParameter("last_name");
	      String email = req.getParameter("email");
	      String hireDate = req.getParameter("hire_date");
	      String jobId = req.getParameter("job_id");
	      String firstName = req.getParameter("first_name");
	      //salary 값이 null 일 경우에는 0, 아니면 integer 
	      int salary =  Integer.parseInt(req.getParameter("salary"));
	      
	      
	      Employee emp = new Employee();
	      emp.setLastName(lastName);
	      emp.setFirstName(firstName);
	      emp.setEmail(email);
	      emp.setHireDate(hireDate);
	      emp.setJobId(jobId);
	      emp.setSalary(salary);
	      
	      
	      
	      
	      
	      
	      EmpDAO dao = new EmpDAO();
	      Employee empl = dao.insertEmBySeq(emp);
	      //JSON{eid" : "?" , "fName":"?" .......}
	      PrintWriter out = resp.getWriter();
	      out.print("{\"employee_id\":\"" +empl.getEmployeeId() + "\"," //
	    		  +"\"last_name\":\"" +empl.getLastName() +"\"," //
	    		  +"\"email\":\"" +empl.getEmail() +"\"," //
	    		  +"\"job_id\":\"" +empl.getJobId() +"\"," //
	    		  +"\"hire_date\":\"" +empl.getHireDate() +"\"" //
	    		  +"\"first_name\":\"" +empl.getFirstName() +"\"" //
	    		  +"\"salary\":\"" +empl.getSalary() +"\"" //
	    		  +"}");
	 
	}
}
