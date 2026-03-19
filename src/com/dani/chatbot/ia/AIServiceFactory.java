
package com.dani.chatbot.ia;
import com.dani.chatbot.config.Config;
import com.dani.chatbot.ia.impl.GeminiService;


public class AIServiceFactory {
    private static final Config config = Config.getInstance();

    public static AIService create(AIProvider provider) {
        switch (provider) {
            case GEMINI:
                return new GeminiService(config.getGeminiApiKey());
            default:
                throw new IllegalArgumentException("Provider no soportado");
        }
    }
}