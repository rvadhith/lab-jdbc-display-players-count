package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {
	
	static TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
	public TreeMap<String,Integer> skillCount() throws Exception {
	
				
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM SKILL ORDER BY NAME");
		ResultSet result = st.executeQuery();
		
		int batCount = 0;
		int bowlCount = 0;
		int wkbCount = 0;
		int allRounderCount = 0;
		
		while(result.next()) {
			String name = result.getString(2);
			switch(name) {
			case "Batting":
				batCount++;
				break;
			case "Bowling":
				bowlCount++;
				break;
			case "Wicket Keeping Batting":
				wkbCount++;
				break;
			case "All Rounder":
				allRounderCount++;
				break;
			}
		}
		
		String s1 = "Batting";
		String s2 = "Bowling";
		String s3 = "Wicket Keeping Batting";
		String s4 = "All Rounder";
		
		tm.put(s1, batCount);
		tm.put(s2, bowlCount);
		tm.put(s3, wkbCount);
		tm.put(s4, allRounderCount);
		
		return tm;
		
	}
}
