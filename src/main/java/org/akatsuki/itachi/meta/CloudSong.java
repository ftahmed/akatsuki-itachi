package org.akatsuki.itachi.meta;

import java.io.Serializable;

/**
 * @author long.yl.
 * @Date 2016/7/1
 */
public class CloudSong implements Serializable {
	private static final long serialVersionUID = 1940189309631955959L;

	private long id;

	private String title;

	private String duration;

	private String lyrics;

	private String url;

	private String tag;

	private long singerId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public long getSingerId() {
		return singerId;
	}

	public void setSingerId(long singerId) {
		this.singerId = singerId;
	}
}
