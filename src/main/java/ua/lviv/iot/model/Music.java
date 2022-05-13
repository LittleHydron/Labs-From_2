package main.java.ua.lviv.iot.model;

public class Music {
	private String genre;
	private String name;
	private String author;
	private double durationInMinutes;
	private double sizeInMb;

	public Music(final String genre, final String name, final String author, final double durationInMinutes,
			final double sizeInMb) {
		this.genre = genre;
		this.name = name;
		this.author = author;
		this.durationInMinutes = durationInMinutes;
		this.sizeInMb = sizeInMb;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(final String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public double getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(final double durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public double getSizeInMb() {
		return sizeInMb;
	}

	public void setSizeInMb(final double sizeInMb) {
		this.sizeInMb = sizeInMb;
	}

	public String getHeaders() {
		return "genre,name,author,durationInMinutes,sizeInMb";
	}

	public String toCSV() {
		return genre + "," + name + "," + author + ","
         + durationInMinutes + "," + sizeInMb;
	}
}
