package main.java.ua.lviv.iot.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import main.java.ua.lviv.iot.model.Music;

public class MusicWriter {
	public void writeToFile(final List<Music> list) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("result.csv");
			writer.write(list.get(0).getHeaders() + "\r\n");
			for (Music m: list) {
				writer.write(m.toCSV() + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
