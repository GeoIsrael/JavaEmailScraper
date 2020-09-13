package com.grabber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSearcher {
	static Set<String> emails = new HashSet<String>();
	static int count = 0;
	String pwd;		

//	File file = new File("/home/g/input/WGET/cybereasy.site/robots.txt");
	

	public static boolean emailSearcher(String path) {
		final Pattern VALID_EMAIL = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", 
				Pattern.CASE_INSENSITIVE);
		
		List<String> list = new ArrayList<String>();
		BufferedReader reader = null;
		File file = new File(path);
		
		try {
			    reader = new BufferedReader(new FileReader(file));
			    String text = null;

			    while ((text = reader.readLine()) != null) {
			        list.add(text);
			    }
			} catch (FileNotFoundException e) {
			    e.printStackTrace();
			    return false;
			} catch (IOException e) {
			    e.printStackTrace();
			    return false;
			} finally {
			    try {
			        if (reader != null) {
			            reader.close();
			        }
			    } catch (IOException e) {
			    }
			}
	
			
	//Here we get list of string in file

			for(String s : list) {     
				Matcher matcher = VALID_EMAIL.matcher(s);
				while(matcher.find()) {
//			         System.out.println(matcher.group());
					emails.add(matcher.group());
					}
			
				}

			
			return true;

			
			
		}
	
	public static int showCount () {
		return count;
	}
	
	public static void printEmail() {
		for(String email: emails) {
			System.out.println(email);
			count ++;
		}
	}
	
	
	}
	


