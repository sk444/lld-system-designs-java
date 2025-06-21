package channel;

import model.Notification;

public class PushChannel implements NotificationChannel
{
    @Override
    public boolean sendNotification(Notification notification)
    {
        System.out.println("[PUSH] Sending to user " + notification.getUserId()
                + ":" + notification.getMessage());
        return true;
    }
}
