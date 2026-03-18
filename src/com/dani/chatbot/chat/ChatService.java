
package com.dani.chatbot.chat;
import com.dani.chatbot.ia.AIService;
import com.dani.chatbot.ia.AIRequest;
import com.dani.chatbot.ia.AIResponse;


public class ChatService {

    private AIService aiService;

    public ChatService(AIService aiService) {
        this.aiService = aiService;
    }

    public void setAIService(AIService aiService) {
        this.aiService = aiService;
    }

    public String sendMessage(String message) {
        // después aquí vas a meter memoria
        AIResponse res = aiService.sendMessage(new AIRequest(message));
        return res.getReply();
    }
}

