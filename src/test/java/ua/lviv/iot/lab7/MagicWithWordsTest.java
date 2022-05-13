package test.java.ua.lviv.iot.lab7;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.Test;

import main.java.ua.lviv.iot.lab7.MagicWithWords;

class MagicWithWordsTest {

	@Test
	void testPerforming() {
		try(BufferedReader f1 = new BufferedReader(new FileReader("expected.txt"));
			BufferedReader f2 = new BufferedReader(new FileReader("result.txt"))){
			var m = new MagicWithWords();
			m.perform("aboba AbObA a_b_o_b_a A_b_O_b_a 10aboba ab0ba Veres abobahalamaha", 6);
			String s = f1.readLine();
			boolean ok = true;
			while(s != null) {
				ok = (ok && s.equals(f2.readLine()));
				s = f1.readLine();
			}
			assertEquals(ok, true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
