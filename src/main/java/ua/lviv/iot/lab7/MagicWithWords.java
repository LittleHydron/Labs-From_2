package main.java.ua.lviv.iot.lab7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagicWithWords {
	public void perform(final String text, final int length) {
		try(BufferedWriter f = new BufferedWriter(new FileWriter("result.txt"))){
			Pattern p = Pattern.compile("[A-Za-z_]+[^\\w]?");
			Matcher m = p.matcher(text);
			while(m.find()) {
				String s = text.substring(m.start(), m.end());
				int l = s.length();
				if (s.endsWith(" ")) l --;
				if (l < length)
					f.write(s+"\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
