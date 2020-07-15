package com.orenn.remindersystem;

import java.util.List;

import javax.swing.JOptionPane;

import com.orenn.remindersystem.beans.Reminder;
import com.orenn.remindersystem.logic.ReminderController;

public class Main {
	
	public static void main(String[] args) {
		
		ReminderController reminderController = new ReminderController();
		// Pop-up reminder system menu
		while (true) {
			String taskSelectionStr = JOptionPane.showInputDialog("Welcome to reminder system!\n"
					+ "Please select the task you would like to perform:\n"
					+ "1. Add reminder\n"
					+ "2. Watch reminders\n"
					+ "3. Exit\n");
			int taskSelection = Integer.parseInt(taskSelectionStr);
			System.out.println("user selected: " + taskSelection);
			
			switch (taskSelection) {
			case 1:
				boolean newReminderState = reminderController.addReminder();
				if (newReminderState) {
					JOptionPane.showMessageDialog(null, "reminder added successfuly");
				}
				else {
					JOptionPane.showMessageDialog(null, "failed to add reminder");
				}
				break;
			case 2:
				List<Reminder> reminders = reminderController.watchReminders();
				for (Reminder reminder : reminders) {
					JOptionPane.showMessageDialog(null, reminder.toString());
				}
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}

}
