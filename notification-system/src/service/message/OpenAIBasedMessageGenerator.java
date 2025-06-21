package service.message;

public class OpenAIBasedMessageGenerator implements MessageContentGenerator
{
    private final OpenAIClient client;

    public OpenAIBasedMessageGenerator(OpenAIClient client)
    {
        this.client = client;
    }

    @Override
    public String generateMessage(String userName, String notificationType)
    {
        String prompt = "Write a short, friendly message to " + userName + " for " + notificationType;
        return client.generateMessage(prompt);
    }
}
