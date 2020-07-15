package com.orenn.remindersystem.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import com.orenn.remindersystem.ReminderTimerTask;
import com.orenn.remindersystem.beans.Reminder;
import com.orenn.remindersystem.exceptions.ApplicationException;

public class ReminderController {
	
	private HashSet<Reminder> reminders;

	public ReminderController() {
		this.reminders = new HashSet<Reminder>();
	}

	public boolean addReminder() {
		try {
			Calendar calendar = getReminderDateAndTime();
			String text = getReminderText();
			Boolean importance = getReminderImportance();
			Reminder reminder = new Reminder(calendar, text, importance, false);
			
			this.reminders.add(reminder);
			scheduleReminder(reminder, calendar);
						
			return true;
		}
		catch (ApplicationException e) {
			return false;
		}
	}

	private void scheduleReminder(Reminder reminder, Calendar scheduleTime) {
		TimerTask reminderTimerTask = new ReminderTimerTask(reminder);
		Timer timer = new Timer();
		timer.schedule(reminderTimerTask, scheduleTime.getTime());
		
	}

	public List<Reminder> watchReminders() {
		ReminderComparator reminderComparator = new ReminderComparator();
		List<Reminder> remindersList = new ArrayList<Reminder>(reminders);
		Collections.sort(remindersList, reminderComparator);
		return remindersList;
	}

	private Calendar getReminderDateAndTime() throws ApplicationException {
		// get date and time input from user
		String dayStr = JOptionPane.showInputDialog("Enter day (dd)");
		String monthStr = JOptionPane.showInputDialog("Enter month (MM)");
		String yearStr = JOptionPane.showInputDialog("Enter year (yyyy)");
		String hourStr = JOptionPane.showInputDialog("Enter hour (HH)");
		String minuteStr = JOptionPane.showInputDialog("Enter minute (mm)");
		
		// convert date and time strings to integers
		int day = Integer.parseInt(dayStr);
		int month = Integer.parseInt(monthStr) - 1;
		int year = Integer.parseInt(yearStr);
		int hour = Integer.parseInt(hourStr);
		int minute = Integer.parseInt(minuteStr);
		
		// create the calendar object
		Calendar calendar = new GregorianCalendar(year, month, day, hour, minute);
		Calendar now = Calendar.getInstance();
		if (calendar.before(now)) {
			throw new ApplicationException();
		}
		
		return calendar;
		
	}
	
	private String getReminderText() {
		String text = JOptionPane.showInputDialog("enter reminder text");
		
		return text;
		
	}
	
	private boolean getReminderImportance() throws ApplicationException {
		int importance = JOptionPane.showConfirmDialog(null, "Is reminder important?", "Reminder importance",
				JOptionPane.YES_NO_OPTION);
		if (importance < 0) {
			throw new ApplicationException("user closed dialog box");
		}
		else if (importance > 0) {
			return false;
		}
		
 		return true;
	}

}
