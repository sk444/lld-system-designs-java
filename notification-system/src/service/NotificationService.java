package service;

import channel.NotificationChannel;
import model.ChannelType;
import model.Notification;
import model.NotificationStatus;
import model.UserPreference;
import retry.RetryHandler;

import java.util.Map;

public class NotificationService {

    private final Map<ChannelType, NotificationChannel> channelMap;
    private final RetryHandler retryHandler;

    public NotificationService(Map<ChannelType, NotificationChannel> channelMap, RetryHandler retryHandler)
    {
        this.channelMap = channelMap;
        this.retryHandler = retryHandler;
    }

    public void sendNotification(Notification notification, UserPreference preference)
    {
        for (ChannelType channelType : preference.getPreferredChannels())
        {
            NotificationChannel channel = channelMap.get(channelType);
            if (channel == null) continue;

            notification.setStatus(NotificationStatus.RETRYING);

            boolean sent = retryHandler.handleRetry(notification, channelType, channel);

            if (sent)
            {
                notification.setStatus(NotificationStatus.SENT);
                System.out.println("Notification sent via " + channelType);
                return;
            }
        }
         notification.setStatus(NotificationStatus.FAILED);
         System.out.println("Notification failed on all channels.");
    }
}
