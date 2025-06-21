package service;

import channel.NotificationChannel;
import model.ChannelType;
import model.Notification;
import model.NotificationStatus;
import model.UserPreference;

import java.util.List;
import java.util.Map;

public class NotificationService {

    private final Map<ChannelType, NotificationChannel> channelMap;

    public NotificationService(Map<ChannelType, NotificationChannel> channelMap) {
        this.channelMap = channelMap;
    }

    public void sendNotification(Notification notification, UserPreference preference)
    {
        List<ChannelType> channels = preference.getPreferredChannels();

        for (ChannelType channelType : channels) {
            NotificationChannel channel = channelMap.get(channelType);

            if (channel == null) {
                System.out.println("No handler found for channel: " + channelType);
                continue;
            }

            boolean success = channel.sendNotification(notification);

            if (success) {
                notification.setStatus(NotificationStatus.SENT);
                System.out.println("Notification sent successfully via " + channelType);
                return;
            } else {
                System.out.println("Failed to send via " + channelType + ". Trying next...");
            }
        }

        notification.setStatus(NotificationStatus.FAILED);
        System.out.println("Notification delivery failed on all preferred channels.");
    }
}
