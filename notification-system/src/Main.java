import channel.EmailChannel;
import channel.NotificationChannel;
import channel.PushChannel;
import channel.SMSChannel;
import model.ChannelType;
import model.Notification;
import model.NotificationType;
import model.UserPreference;
import retry.InMemoryRetryHandler;
import retry.RetryHandler;
import service.NotificationService;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main
{
    public static void main(String[] args) {
        Notification notification = new Notification(
                UUID.randomUUID().toString(),
                "user123",
                "🚚 Your order #123456 has been shipped!",
                NotificationType.ORDER_UPDATE,
                Instant.now().toEpochMilli()
        );

        // Define user preferences (order matters)
        UserPreference preference = new UserPreference(
                "user123",
                Arrays.asList(ChannelType.SMS, ChannelType.EMAIL, ChannelType.PUSH)
        );

        Map<ChannelType, NotificationChannel> channelMap = new HashMap<>();

        channelMap.put(ChannelType.EMAIL, new EmailChannel());
        channelMap.put(ChannelType.PUSH, new PushChannel());
        channelMap.put(ChannelType.SMS, new SMSChannel());

        RetryHandler retryHandler = new InMemoryRetryHandler(3);

        NotificationService notificationService = new NotificationService(channelMap, retryHandler);

        notificationService.sendNotification(notification, preference);

        System.out.println("Final Notification Status: " + notification.getStatus());
    }
}