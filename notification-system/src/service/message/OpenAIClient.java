package service.message;

import okhttp3.*;
import com.google.gson.*;

import java.io.IOException;

public class OpenAIClient {

    private static final String ENDPOINT = "https://api.openai.com/v1/chat/completions";
    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey;

    public OpenAIClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String generateMessage(String prompt) {
        JsonObject json = new JsonObject();
        json.addProperty("model", "gpt-3.5-turbo");

        JsonArray messages = new JsonArray();
        JsonObject userMsg = new JsonObject();
        userMsg.addProperty("role", "user");
        userMsg.addProperty("content", prompt);
        messages.add(userMsg);
        json.add("messages", messages);

        json.addProperty("temperature", 0.7);
        json.addProperty("max_tokens", 100);

        RequestBody body = RequestBody.create(
                json.toString(),
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(ENDPOINT)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("❌ OpenAI API error: " + response.code() + " - " + response.message());
                System.err.println("👉 Response body: " + response.body().string());
                return "[AI] Error: " + response.code();
            }

            String responseBody = response.body().string();
            JsonObject responseJson = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonArray choices = responseJson.getAsJsonArray("choices");

            return choices.get(0).getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content")
                    .getAsString()
                    .trim();

        } catch (IOException e) {
            System.err.println("❌ Network error: " + e.getMessage());
            return "[AI] Failed to generate message.";
        }
    }
}
