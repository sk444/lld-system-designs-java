package channel;

import model.Notification;

public interface NotificationChannel
{
    boolean sendNotification(Notification notification);
}
