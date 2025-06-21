package retry;

import channel.NotificationChannel;
import model.ChannelType;
import model.Notification;

public interface RetryHandler
{
    boolean handleRetry(Notification notification, ChannelType channelType, NotificationChannel channel);
}
