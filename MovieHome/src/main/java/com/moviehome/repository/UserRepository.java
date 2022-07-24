package com.moviehome.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.moviehome.model.User;
import com.moviehome.service.MovieService;

import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class UserRepository { // Diğer projedeki User entity'sine ulaşabilmek adına JDBC kullanıldı. User Id, membership gibi değerler movie giriş kısmında
	// Önem taşıyan bir noktadadır.
	
	Connection con = null;// Bağlantı sayesinde uygulama ve db ile görüşme yapılır.;
	
	@SuppressWarnings("finally")
	public boolean userPresent(int id) {// User'ın var olup olmadığını kontrol eder
		String query = "SELECT * FROM users WHERE user_id=?";
		int idHolder=0;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mov", "postgres", "123");
			PreparedStatement statement;
			statement = con.prepareStatement(query);
			statement.setInt(1,id);
			ResultSet result=statement.executeQuery();
			
			while(result.next()) {
				idHolder=result.getInt("user_id");
				
			}
			
			
			con.close();
			
		}
		catch(Exception e) {
			
		}
		finally {
			if(idHolder==0) {
				return false;
			}
			else {
				return true;
			}
		}

	}
	
	
	
	@SuppressWarnings("finally")
	public User findUserSubVer(int id) {// Verilen id ile User'ı çeker ve MovieHome için tasarlanan versiyonu ile eşitlenmeye çalışılır.
		String query = "SELECT * FROM users WHERE user_id=?";
		User holderUser=new User();
		log.info("hax");
		try {
			log.info("hax");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mov", "postgres", "123");
			PreparedStatement statement;
			statement = con.prepareStatement(query);
			statement.setInt(1,id);
			ResultSet result=statement.executeQuery();
			
			while(result.next()) {
				log.info("hax");
				holderUser.setUserId(result.getInt("user_id"));
				holderUser.setFullName(result.getString("full_name"));
				holderUser.setEmail(result.getString("email"));
				holderUser.setMembershipType(result.getString("membership_type"));
				holderUser.setMembershipTime(result.getInt("membership_time"));
				holderUser.setMovieCount(result.getInt("movie_count"));
				
			}
			
			
			con.close();
			
		}
		catch(Exception e) {
			
		}
		finally {
			return holderUser;
		}

	}
	
	
	

}
