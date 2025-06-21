package channel;

import model.Notification;

public class EmailChannel implements NotificationChannel
{
    @Override
    public boolean sendNotification(Notification notification) {
        System.out.println("[EMAIL] Sending to user " + notification.getUserId()
                + ": " + notification.getMessage());
        // Simulate success
        return true;
    }
}
