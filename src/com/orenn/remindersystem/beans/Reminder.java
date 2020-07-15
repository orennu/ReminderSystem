package com.orenn.remindersystem.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reminder {
	
	private Calendar expiration;
	private String text;
	private boolean important;
	private boolean poped;
	
	public Reminder(Calendar expiration, String text, boolean important, boolean poped) {
		this.expiration = expiration;
		this.text = text;
		this.important = important;
		this.poped = poped;
	}
	
	public Calendar getExpiration() {
		return expiration;
	}
	public void setExpiration(Calendar expiration) {
		this.expiration = expiration;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	public boolean isPoped() {
		return poped;
	}
	public void setPoped(boolean poped) {
		this.poped = poped;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiration == null) ? 0 : expiration.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reminder other = (Reminder) obj;
		if (expiration == null) {
			if (other.expiration != null)
				return false;
		} else if (!expiration.equals(other.expiration))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm");
		String expirationStr = sdf.format(expiration.getTime());
		return "Reminder!!!\n" + text + "\n\nexpiration: " + expirationStr + "\n" + "\nimportant: " + important + "\nseen: " + poped;
	}
	
}
