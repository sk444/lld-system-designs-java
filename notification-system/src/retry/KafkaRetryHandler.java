package retry;

import channel.NotificationChannel;
import model.ChannelType;
import model.Notification;

// future scope
public class KafkaRetryHandler implements RetryHandler
{
    @Override
    public boolean handleRetry(Notification notification, ChannelType channelType, NotificationChannel channel)
    {
        System.out.println("Pushing to Kafka retry-topic for async retry: " + channelType);
        // logic to serialize and send to Kafka topic
        return false;
    }
}
