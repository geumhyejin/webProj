package fileboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;

public class FileDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public FileVO getFile(int num) {  //num 값으로 한건 조회
		conn = DBCon.getConnect();
		String sql = "select * from file_board where num = ?";
		FileVO file = new  FileVO();
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			if(rs.next()) {
				file.setAuthor(rs.getString("author"));
				file.setDay(rs.getString("day"));
				file.setFileName(rs.getString("file_name"));
				file.setNum(rs.getInt("num"));
				file.setTitile(rs.getString("title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
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
		return file;
	}

	public List<FileVO> getFileList() {
		conn = DBCon.getConnect();
		List<FileVO> list = new ArrayList<FileVO>();
		try {
			psmt = conn.prepareStatement("select * from file_board");
			rs = psmt.executeQuery();
			while (rs.next()) {
				FileVO vo = new FileVO();
				vo.setAuthor(rs.getString("author"));
				vo.setDay(rs.getString("day"));
				vo.setFileName(rs.getString("file_name"));
				vo.setNum(rs.getInt("num"));
				vo.setTitile(rs.getString("title"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
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

		return list;
	}

	public FileVO getInsertKeyVal(FileVO vo) {
		conn = DBCon.getConnect();
		// 신규번호 한건입력, 한건조회
		String selectKey = "select nvl(max(num),0)+1 from file_board";
		String insertSql = "insert into file_board values(?,?,?,?, to_char(sysdata,'YYYY-MM-DD'))";
		String selectSql = "select * from file_board where num = ?";
		FileVO file = new FileVO();
		int key = 0;
		
		try { // key값을 가져오는 쿼리
			psmt = conn.prepareStatement(selectKey);
			rs = psmt.executeQuery();
			if (rs.next()) {
				key = rs.getInt(1);
			}
			// 새로운 키값을 한건입력
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, key);
			psmt.setString(2, vo.getAuthor());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getFileName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			
			
			// 신규입력된 전체정보 가져오도록
			psmt = conn.prepareStatement(selectSql);
			psmt.setInt(1, key);
			rs = psmt.executeQuery();
			if (rs.next()) {
				file.setAuthor(rs.getString("author"));
				file.setDay(rs.getString("day"));
				file.setFileName(rs.getString("filename"));
				file.setNum(rs.getInt("num"));
				file.setTitile(rs.getString("title"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
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

		return file;
	}
}
