package com.orenn.remindersystem;

import java.util.TimerTask;

import javax.swing.JOptionPane;
import com.orenn.remindersystem.beans.Reminder;

public class ReminderTimerTask extends TimerTask {
	
	private Reminder reminder;
	
	public ReminderTimerTask(Reminder reminder) {
		this.reminder = reminder;
	}
	
	@Override
	public void run() {
		if (reminder.isImportant()) {
			for (int i = 0; i < 4; i++) {
				JOptionPane.showMessageDialog(null, reminder.toString());
				reminder.setPoped(true);
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, reminder.toString());
		}
	}

}