package com.orenn.remindersystem.logic;

import java.util.Comparator;

import com.orenn.remindersystem.beans.Reminder;

public class ReminderComparator implements Comparator<Reminder> {
	
	@Override
	public int compare(Reminder firstReminder, Reminder secondReminder) {
		return firstReminder.getExpiration().getTime().compareTo(secondReminder.getExpiration().getTime());
	}
}
