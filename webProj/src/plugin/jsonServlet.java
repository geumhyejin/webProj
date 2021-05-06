package plugin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/jsonServlet")
public class jsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public jsonServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		JSONObject outObj = new JSONObject();
		JSONArray fAry = new JSONArray();
		fAry.add("Reading");
		fAry.add("Sleeping");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	
	}

}
