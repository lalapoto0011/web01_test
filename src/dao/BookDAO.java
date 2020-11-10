package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO {
	
	public List<BookVO> BookList() {
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM book ORDER BY bookno desc";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					BookVO vo = new BookVO();
					vo.setBookno(rs.getInt("bookno"));
					vo.setPrice(rs.getInt("price"));
					vo.setPublisher(rs.getNString("publisher"));
					vo.setTitle(rs.getNString("title"));
					
					list.add(vo);
				}
				
				
			} catch (SQLException e) {
				System.out.println("error" + e);
			} finally {
				JDBCUtil.close(con, ps, rs);
			}
			
			return list;
	}
	
	
	public void BookAdd(BookVO vo) {
		String sql = "INSERT INTO book (bookno, title, publisher, price) VALUES (?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, vo.getBookno());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getPublisher());
			ps.setInt(4, vo.getPrice());
			
//			ps.executeQuery(); //select
			row = ps.executeUpdate(); //insert, update, delete
			
			if (row == 0) { //insert 값이 없다
				throw new Exception("등록 실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		
	}
	
	public void BookDelete(int bookno) {
		int row = 0;
		
		String sql = "DELETE FROM book WHERE bookno = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bookno);
			
//			ps.executeQuery(); //select
			row = ps.executeUpdate(); //insert, update, delete
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}	
		
	}
	
	
	
	public void BookUpdate(BookVO vo) {
		
	String sql = "UPDATE book SET price = ? WHERE bookno = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, vo.getPrice());
			ps.setInt(2, vo.getBookno());
			
//			ps.executeQuery(); //select
			ps.executeUpdate(); //insert, update, delete
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
	}
	
	public List<BookVO> BookSearch(String condition, String keyword) { //condition 자리에 타이틀, 퍼블리셔 들어갈 수 있음
		
		String sql = "SELECT * FROM book WHERE " + condition + "LIKE ? ORDER BY bookno DESC";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" + keyword + "%"); //앞뒤 %처리 해줘야 포함 키워드로 검색됨
			
			rs = ps.executeQuery(); //select
//			ps.executeUpdate(); //insert, update, delete
			
			while (rs.next()) { //결과값 처리
				BookVO vo = new BookVO();
				
				vo.setBookno(rs.getInt("bookno"));
				vo.setPrice(rs.getInt("price"));
				vo.setPublisher(rs.getNString("publisher"));
				vo.setTitle(rs.getNString("title"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		} return list;
		
	}
	
	public BookVO getBook(int bookno) { //상세보기
		
		String sql = "SELECT * FROM book WHERE " + condition + "LIKE ? ORDER BY bookno DESC";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "%" + keyword + "%"); //앞뒤 %처리 해줘야 포함 키워드로 검색됨
			
			rs = ps.executeQuery(); //select
//			ps.executeUpdate(); //insert, update, delete
			
			while (rs.next()) { //결과값 처리
				BookVO vo = new BookVO();
				
				vo.setBookno(rs.getInt("bookno"));
				vo.setPrice(rs.getInt("price"));
				vo.setPublisher(rs.getNString("publisher"));
				vo.setTitle(rs.getNString("title"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		} return list;
		
	}
		
		
		
		
		
	}

}
