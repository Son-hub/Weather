package com.naver.dao;


import java.sql.*;
import java.util.ArrayList;
import com.naver.db.DB;
import com.naver.dto.HugiDto;
import com.naver.dto.HugiPrintDto;

public class HugiDaoImpl implements HugiDao{

	@Override
	public void insert(HugiDto dto) {
		// 디비 연결
		// 쿼리 만들고
		// 쿼리 실행

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO hugi (mb_num, mv_num, title, content) ");
			sql.append("VALUES (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, dto.getMb_num());
			pstmt.setInt(2, dto.getMv_num());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<HugiPrintDto> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<HugiPrintDto> list = new ArrayList<HugiPrintDto>();
		try {
			conn = DB.conn();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT h.no, m.je, h.title, h.score, ");
			sql.append("(SELECT name FROM member WHERE num = h.mb_num) AS name ");
			sql.append("FROM movie m join hugi h on m.num = h.mv_num");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getString("no"));
//				System.out.println(rs.getString("je"));
//				System.out.println(rs.getString("title"));
//				System.out.println(rs.getString("score"));
//				System.out.println(rs.getString("name"));
				HugiPrintDto dto = new HugiPrintDto();
				dto.setNo(rs.getInt("no"));
				dto.setJe(rs.getString("je"));
				dto.setTitle(rs.getString("title"));
				dto.setScore(rs.getInt("score"));
				dto.setName(rs.getString("name"));	
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void update(HugiDto dto) {

//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = DB.conn(); 
//			String sql = "UPDATE user SET jumsu=? WHERE  id=?";
//			pstmt = conn.prepareStatement(sql);
//			
////			pstmt.setInt(1, dto.getJumsu());
//			pstmt.setString(2, dto.getId());
//			
//			int count = pstmt.executeUpdate();
//			if (count == 0) {
//				System.out.println("데이터 입력 실패");
//			} else {
//				System.out.println("데이터 입력 성공");
//			}
//
//		} catch (Exception e) {
//			System.out.println("에러: " + e);
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//				if( pstmt != null && !pstmt.isClosed()){
//                    pstmt.close();
//                }
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
	}

	@Override
	public HugiPrintDto select(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		HugiPrintDto dto = new HugiPrintDto();
		try {
			conn = DB.conn();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT h.no, m.je, h.title, h.score, h.content, ");
			sql.append(" (SELECT name FROM member WHERE num = h.mb_num) AS name ");
			sql.append(" FROM movie m join hugi h on m.num = h.mv_num WHERE h.no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				System.out.println(rs.getString("no"));
//				System.out.println(rs.getString("je"));
//				System.out.println(rs.getString("title"));
//				System.out.println(rs.getString("score"));
//				System.out.println(rs.getString("name"));
				dto.setNo(rs.getInt("no"));
				dto.setJe(rs.getString("je"));
				dto.setTitle(rs.getString("title"));
				dto.setScore(rs.getInt("score"));
				dto.setName(rs.getString("name"));	
				dto.setContent(rs.getString("content"));	
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

}