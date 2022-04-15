package ua.lviv.iot.manager.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ua.lviv.iot.manager.IMusicShopManager;
import ua.lviv.iot.model.Music;

public class MusicShopManager implements IMusicShopManager{
	Map<String, List<Music>> content = new HashMap<>();

	@Override
	public List<Music> findByGenreForCD(String genre) {
		List<Music> list = new LinkedList<>();
		content.get(genre).forEach(music->{
			if (music.getGenre().equals(genre)) list.add(music);
		});
		return list;
	}

	@Override
	public List<Music> getSortedByIncreasingDuration(List<Music> list) {
		list.sort(Comparator.comparing(Music::getDurationInMinutes));
		
		return list;
	}

	@Override
	public List<Music> getSortedByDecreasingDuration(List<Music> list) {
		list.sort(Comparator.comparing(Music::getDurationInMinutes).reversed());
		return list;
	}

	@Override
	public List<Music> getSortedByIncreasingSize(List<Music> list) {
		 list.sort(Comparator.comparing(Music::getSizeInMb));
		return list;
	}

	@Override
	public List<Music> getSortedByDecreasingSize(List<Music> list) {
		list.sort(Comparator.comparing(Music::getSizeInMb).reversed());
		return list;
	}
}