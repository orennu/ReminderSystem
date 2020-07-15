# Reminder/Notifications system
## The story
Reminder system should provide the user with interface with 3 options:  
1. Add reminders  
2. Watch existing reminders  
3. Exit  
  
Reminders should have the following features:  
1. expiration/due date - the time when the reminder should pop to the user  
2. text - the message content of the reminder  
3. importance - indicates whether the reminder is important or not  
4. seen - indicates whether the reminder was seen by the user or not  
  
For each reminder the user should get a pop-up window when the reminder's expiration date arrived  
For important reminders the user should get 3 more reminders with 1 minute delay between each reminder after the first reminder  
When reminder should be marked as unseen when pops for the first time and as seen afterwards  
When the user wants to watch the reminders they should appear by the order of expiration (from oldest to newest)  
Reminder should not be deleted  
There is no need for user input validation with the following exceptions:  
1. Reminders with the same expiration and text are not allowed  
2. Reminders with expiration in the past are not allowed  

