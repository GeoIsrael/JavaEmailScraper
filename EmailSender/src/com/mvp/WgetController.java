package com.mvp;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class WgetController {

	public static void main(String[] args) {
//target
		String target = "cybereasy.site";

//command
		String cmd = "wget -c -r -l100 --progress=dot " + target; 				// + " -O 1";

		
		String s;
        Process p;
 
        
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        
        try {

          p = Runtime.getRuntime().exec(cmd, null, new File("/home/g/input/WGET/"));

          
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {}
    }


	}


//Console console = System.console();
//if (console == null) {
//    System.out.println("Unable to fetch console");
//    return;
//}
//String line = console.readLine();
//console.printf("I saw this line: %s", line);

