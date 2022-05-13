package test.java.ua.lviv.iot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ua.lviv.iot.model.Music;

class MusicTest {

	@Test
	void testGetHeaders() {
		Music m = new Music("rock", "Ruslan", "Igor", 12.5, 10);
		assertEquals("genre,name,author,durationInMinutes,sizeInMb", m.getHeaders());
	}

	@Test
	void testToCSV() {
		Music m = new Music("rock", "Ruslan", "Igor", 12.5, 10);
		assertEquals("rock,Ruslan,Igor,12.5,10.0", m.toCSV());
	}

}
