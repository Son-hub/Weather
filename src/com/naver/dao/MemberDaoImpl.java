package com.naver.dao;


import java.sql.*;
import java.util.ArrayList;

import com.naver.db.DB;
import com.naver.dto.MemberDto;

public class MemberDaoImpl implements MemberDao{

	@Override
	public void insert(MemberDto dto) {
		// 디비 연결
		// 쿼리 만들고
		// 쿼리 실행

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
			String sql = "INSERT INTO member (email, pw, name, tel) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			
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
	public boolean select(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isEmail = false;   // 데이터가 없으면 false
		try {
			conn = DB.conn();
//			String sql = "SELECT * FROM user WHERE  id= '" + id + "'";
			String sql = "SELECT * FROM member WHERE  email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isEmail = true;  // 데이터가 있으면 true
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
		return isEmail;
	}

	@Override
	public ArrayList<MemberDto> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setEmail(rs.getString("email"));
				dto.setName(rs.getString("name"));
//				dto.setJumsu(rs.getInt("jumsu"));
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
	public void update(MemberDto dto) {

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
	public MemberDto select(String email, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		MemberDto dto = null;
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM member WHERE  email = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setEmail(rs.getString("email"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
			} else {
				System.out.println("사용자가 없다");
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