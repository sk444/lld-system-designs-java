package service.message;

public class MessageGeneratorFactory
{
    public static String create()
    {
        /*
         Decide generator based on OpenAI availability
         */
        MessageContentGenerator generator;

        String apiKey = System.getenv("OPENAI_API_KEY");

        /*
         Generate the message dynamically
         */
        String generatedMessage;

        if (apiKey != null && !apiKey.isBlank()) {
            System.out.println("✅ Using OpenAI for message generation");
            OpenAIClient client = new OpenAIClient(apiKey);
            generator = new OpenAIBasedMessageGenerator(client);
            generatedMessage = generator.generateMessage("Shubham", "Order Update");
        }
        else
        {
            System.out.println("⚠OPENAI_API_KEY not set. Falling back to static msg.");
            generatedMessage = "🚚 Your order #123456 has been shipped!";
        }
        return generatedMessage;
    }
}
