package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.TreeMap;

import dao.SkillDAO;
import model.Skill;

public class Main{
	public static void main(String args[])throws Exception{
		SkillDAO skilldao = new SkillDAO();
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map = skilldao.skillCount();
		System.out.println("Skill"+"\t\t"+"Count");
		
		for(Entry<String, Integer> entry : map.entrySet() ){
		    System.out.println( entry.getKey() + " => " + entry.getValue());
		}
	}
	
}
