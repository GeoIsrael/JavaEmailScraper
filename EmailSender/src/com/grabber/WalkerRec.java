package com.grabber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WalkerRec {

	public static void main(String[] args) throws IOException {
	
		final String pwd = "/home/g/input/WGET/";       

	
//Get List of files patchs 
		
		List<Object> paths = 
    	Files.walk(Paths.get(pwd))
        .filter(Files::isRegularFile)
        .distinct()
        .collect(Collectors.toList());
		
		
		System.out.println("Count files = " + paths.size());
		
		for(Object path: paths) {
			EmailSearcher.emailSearcher(path.toString());
		}
		
		EmailSearcher.printEmail();
		
		System.out.println("Total email: " + EmailSearcher.showCount());
		
		
	
		
	}
}	

