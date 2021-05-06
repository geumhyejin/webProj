//package plugin;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import common.DBCon;
//import common.scheduleVO;
//
//
//@WebServlet("jquery/scheduleDelServlet")
//public class scheduleDelServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
// 
//    public scheduleDelServlet() {
//        super();
//        
//    }
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		
//		 Connection conn = DBCon.getConnect();
//		 scheduleVO vo = new scheduleVO();
//	      PreparedStatement psmt = null;
//	      
//	      String sql = "delete from schedule where title =?";
//	      
//	      try {
//	         psmt = conn.prepareStatement(sql);
//	         psmt.setString(1, vo.getTitle() );
//	         psmt.setString(2, vo.getStartDay() );
//	         psmt.setString(3, vo.getEndDay() );
//	         int del = psmt.executeUpdate();
//	         System.out.println(del+"건 삭제완료.");
//	         
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      }finally {
//	         if(psmt!=null) {
//	            try {
//	               psmt.close();
//	            } catch (SQLException e) {
//	               
//	               e.printStackTrace();
//	            }
//	         }
//	         if(conn!=null) {
//	            try {
//	               conn.close();
//	            } catch (SQLException e) {
//	               
//	               e.printStackTrace();
//	            }
//	         }
//	         }
//	   }
//	
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//	
//		
//	}
//
//}
