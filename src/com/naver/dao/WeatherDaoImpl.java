package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.db.DB;
import com.naver.dto.WeatherDto;

public class WeatherDaoImpl implements WeatherDao{

	@Override
	public void insert(WeatherDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO weather_Accu(temp, realfeel, precip, hum) ");
			sql.append("SELECT ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS ");
			sql.append("(SELECT temp, realfeel, precip, hum FROM weather_Accu WHERE temp = ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getTemp());
			pstmt.setInt(2, dto.getRealfeel());
			pstmt.setInt(3, dto.getPrecip());
			pstmt.setInt(4, dto.getHum());
			
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
	public ArrayList<WeatherDto> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<WeatherDto> list = new ArrayList<WeatherDto>();
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM weather_Accu";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("temp"));
				WeatherDto dto = new WeatherDto();
				dto.setTemp(rs.getString("temp"));
				dto.setRealfeel(rs.getInt("realfeel"));
				dto.setPrecip(rs.getInt("precip"));
				dto.setHum(rs.getInt("hum"));
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

}
