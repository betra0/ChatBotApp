
package com.dani.chatbot.ia;
import com.dani.chatbot.ia.impl.GeminiService;


public class AIServiceFactory {

    public static AIService create(AIProvider provider) {
        switch (provider) {
            case GEMINI:
                return new GeminiService();
            default:
                throw new IllegalArgumentException("Provider no soportado");
        }
    }
}