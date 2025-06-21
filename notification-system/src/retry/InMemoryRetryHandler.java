package retry;

import channel.NotificationChannel;
import model.ChannelType;
import model.Notification;

public class InMemoryRetryHandler implements RetryHandler
{
    private final int maxRetries;

    public InMemoryRetryHandler(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public boolean handleRetry(Notification notification, ChannelType channelType, NotificationChannel channel)
    {
        for (int attempt = 1; attempt <= maxRetries; attempt++)
        {
            if (attempt > 1)
            {
                System.out.println("Retrying (" + attempt + "/" + maxRetries + ") for " + channelType);
            }
            boolean success = channel.sendNotification(notification);
            if (success)
            {
                return true;
            }
        }
        System.out.println("All retries failed for " + channelType);
        return false;
    }
}
