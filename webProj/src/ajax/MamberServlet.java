package ajax;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.Rdn;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBCon;

@WebServlet("/jquery/memberServlet.do")
public class MamberServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MamberServlet() {
      super();

   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      //조회작업
      Connection conn = DBCon.getConnect();
      PreparedStatement psmt = null;
      ResultSet rs = null;
      
      String sql = "select * from member";
      String json = "[";
      
      try {
         psmt = conn.prepareStatement(sql, 
               ResultSet.TYPE_SCROLL_INSENSITIVE, 
               ResultSet.CONCUR_UPDATABLE);
         rs = psmt.executeQuery();
         
         while(rs.next()) {
            String memId = rs.getString(1);
            String memName = rs.getString(2);
            String memAge = rs.getString(3);
            
            json += "{\"ID\":\""+ memId //
               +"\",\"Name\":\""+ memName //
               +"\",\"Age\":\""+ memAge +"\"}";
            
//            json += "{\"Id\":\""+memId//
//                        +"\",\"name\":\""+memName//
//                        +"\",\"age\":\""+memAge//
//                        +"\"}";
            
            if(!rs.isLast()) {
               json += ",";
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         if(rs != null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if(psmt != null) {
            try {
               psmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if(conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      json +=   "]";   
      //조회 결과를 json 형식으로 작성해보기
      //[{"id":1, "name":"choi", "age":31},
      // {"id":1, "name":"choi", "age":31},
      // {"id":1, "name":"choi", "age":31}]
      
      //결과를 response.getWriter().print();로 출력해보기
      response.getWriter().print(json);
      
      
      // Tip> 만약 파라미터로 전달되는 데이터의 한글 처리가 필요할 때는
      // request.setCharacterEncoding("utf-8"); 을 사용한다.
      // response.setContentType나 request.setCharacterEncoding은
      // 값을 받아오는 변수나 화면에 출력하는(print 같은) 구문 위에 먼저 위치해야 한다.
      
//      response.getWriter().print("<h2>정상적으로 조회되었습니다.</h2>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      //입력작업
                        //       ┌>jq_ajax4.html의 input에 있는 name의 값이 파라미터로 쓰임.
      String p1 = request.getParameter("m_id");
      String p2 = request.getParameter("m_name");
      String p3 = request.getParameter("m_age");

      Connection conn = DBCon.getConnect();
      PreparedStatement psmt = null;
      String sql = "insert into member values(?,?,?)";
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, p1);
         psmt.setString(2, p2);
         psmt.setString(3, p3);
         int r = psmt.executeUpdate();

         System.out.println(r + "건 입력완료.");
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if (psmt != null) {
            try {
               psmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         if (conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
      String json = "{\"ID\":"+p1+",\"Name\":\""+p2+"\",\"Age\":"+p3+"}";
//      response.setContentType("text/html;charset=UTF-8");
      response.getWriter().print(json);
   }

}