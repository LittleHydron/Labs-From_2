package test.java.ua.lviv.iot.manager.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.ua.lviv.iot.manager.impl.MusicShopManager;
import main.java.ua.lviv.iot.model.Music;



class MusicShopManagerTest {
	@Test
	void testFindByGenreForCD() {
		MusicShopManager manager = new MusicShopManager();
		manager.addMusic(new Music("rock", "Ruslan", "Igor", 12.5, 10));
		manager.addMusic(new Music("rap", "12", "Morgenshtern", 10, 110));
		manager.addMusic(new Music("rock", "Ares_sword", "Shadow_of_Sun", 13, 20));
		manager.addMusic(new Music("trap", "TrapLuv", "BBT", 9, 2));
		manager.addMusic(new Music("rock", "365", "Days", 8, 20));
		
		final String genre = "rock"; 
		
		List<Music> lst = manager.findByGenreForCD(genre);
		for (Music m: lst) {
			if (!m.getGenre().equals(genre)) fail("Genre mismatch!");
		}
		for (Music m: lst) {
			if (m.getDurationInMinutes() > 10) fail("Duration is too big");
		}
	}

	@Test
	void testGetSortedByIncreasingDuration() {
		MusicShopManager manager = new MusicShopManager();
		List<Music> lst = new LinkedList<>();
		lst.add(new Music("rock", "Ruslan", "Igor", 12.5, 10));
		lst.add(new Music("rap", "12", "Morgenshtern", 10, 110));
		lst.add(new Music("rock", "Ares_sword", "Shadow_of_Sun", 13, 20));
		lst.add(new Music("trap", "TrapLuv", "BBT", 9, 2));
		lst.add(new Music("rock", "365", "Days", 8, 20));
		
		lst = manager.getSortedByIncreasingDuration(lst);
		for (int i=1; i<lst.size(); i++) {
			if (lst.get(i).getDurationInMinutes() < lst.get(i-1).getDurationInMinutes()) {
				fail("List was not sorted");
			}
		}
	}

	@Test
	void testGetSortedByDecreasingDuration() {
		MusicShopManager manager = new MusicShopManager();
		List<Music> lst = new LinkedList<>();
		lst.add(new Music("rock", "Ruslan", "Igor", 12.5, 10));
		lst.add(new Music("rap", "12", "Morgenshtern", 10, 110));
		lst.add(new Music("rock", "Ares_sword", "Shadow_of_Sun", 13, 20));
		lst.add(new Music("trap", "TrapLuv", "BBT", 9, 2));
		lst.add(new Music("rock", "365", "Days", 8, 20));
		
		lst = manager.getSortedByDecreasingDuration(lst);
		for (int i=1; i<lst.size(); i++) {
			if (lst.get(i).getDurationInMinutes() > lst.get(i-1).getDurationInMinutes()) {
				fail("List was not sorted");
			}
		}
	}

	@Test
	void testGetSortedByIncreasingSize() {
		MusicShopManager manager = new MusicShopManager();
		List<Music> lst = new LinkedList<>();
		lst.add(new Music("rock", "Ruslan", "Igor", 12.5, 10));
		lst.add(new Music("rap", "12", "Morgenshtern", 10, 110));
		lst.add(new Music("rock", "Ares_sword", "Shadow_of_Sun", 13, 20));
		lst.add(new Music("trap", "TrapLuv", "BBT", 9, 2));
		lst.add(new Music("rock", "365", "Days", 8, 20));
		
		lst = manager.getSortedByIncreasingSize(lst);
		for (int i=1; i<lst.size(); i++) {
			if (lst.get(i).getSizeInMb() < lst.get(i-1).getSizeInMb()) {
				fail("List was not sorted");
			}
		}
	}

	@Test
	void testGetSortedByDecreasingSize() {
		MusicShopManager manager = new MusicShopManager();
		List<Music> lst = new LinkedList<>();
		lst.add(new Music("rock", "Ruslan", "Igor", 12.5, 10));
		lst.add(new Music("rap", "12", "Morgenshtern", 10, 110));
		lst.add(new Music("rock", "Ares_sword", "Shadow_of_Sun", 13, 20));
		lst.add(new Music("trap", "TrapLuv", "BBT", 9, 2));
		lst.add(new Music("rock", "365", "Days", 8, 20));
		
		lst = manager.getSortedByDecreasingSize(lst);
		for (int i=1; i<lst.size(); i++) {
			if (lst.get(i).getSizeInMb() > lst.get(i-1).getSizeInMb()) {
				fail("List was not sorted");
			}
		}
	}
	
	@Test
	public void testAddMusic() {
		MusicShopManager manager = new MusicShopManager();
		Music m = new Music("rock", "Ruslan", "Igor", 10, 10);
		manager.addMusic(m);
		if (!manager.findByGenreForCD("rock").contains(m)) {
			fail("Music was not added");
		}
	}

}
