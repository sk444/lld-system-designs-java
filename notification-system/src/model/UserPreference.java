package model;

import java.util.List;

public class UserPreference
{
    private final String userId;

    private final List<ChannelType> preferredChannels;

    public UserPreference(String userId, List<ChannelType> preferredChannels) {
        this.userId = userId;
        this.preferredChannels = preferredChannels;
    }

    public String getUserId() {
        return userId;
    }

    public List<ChannelType> getPreferredChannels() {
        return preferredChannels;
    }
}
