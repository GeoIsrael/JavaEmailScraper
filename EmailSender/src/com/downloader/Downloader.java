package com.downloader;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.grabber.EmailSearcher;

public class Downloader {

	static Set<String> urls = new HashSet<String>();
	static int count =0;
	
	
	public static void main(String[] args) throws Exception {
		
		Pattern p = Pattern.compile( "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",Pattern.CASE_INSENSITIVE);

		String response = "";
		String url = "https://aps-site.ru/";
//		-----------------
		
		response = c.getHTML(url);
//		System.out.println(response);
		
		
//		com.grabber.EmailSearcher.emailSearcher(response);
//		EmailSearcher.printEmail();
		
        Matcher m = p.matcher(response);
        while (m.find()) {
            for (int i = 1; i <= m.groupCount(); i++) {
                urls.add(m.group(i));
                count ++;	
            }
        }

        System.out.println(count);
        for (String u: urls) {
        	System.out.println(u);
        }
		
		
		
		
		
		
//	---------------------------
	}
}
