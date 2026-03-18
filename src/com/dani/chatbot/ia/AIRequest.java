
package com.dani.chatbot.ia;

import java.util.Map;

public class AIRequest {
    
    private String message;
    private Map<String, Object> memory;
    
    public AIRequest(String message, Map<String, Object> memory) {
        this.message = message;
        this.memory = memory;
    }
    public AIRequest(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMemory(Map<String, Object> memory) {
        this.memory = memory;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getMemory() {
        return memory;
    }
    
    
    
 
}