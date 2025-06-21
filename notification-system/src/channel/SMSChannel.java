package channel;

import model.Notification;

public class SMSChannel implements NotificationChannel
{
    @Override
    public boolean sendNotification(Notification notification) {
        System.out.println("[SMS] Sending to user " + notification.getUserId()
                + ": " + notification.getMessage());
        // Simulate failure to test fallback
        return false;
    }
}
