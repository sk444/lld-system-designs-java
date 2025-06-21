package model;

public class Notification
{
    private final String id;
    private final String userId;
    private final String message;
    private final NotificationType type;
    private NotificationStatus status;
    private final long createdAt;

    public Notification(String id, String userId, String message, NotificationType type, long createdAt)
    {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getType() {
        return type;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}