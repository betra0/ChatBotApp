
package com.dani.chatbot.ia;
import java.util.List;

public class AIResponse {
    private String reply;
    private List<String> functions; 

    public AIResponse(String reply, List<String> functions) {
        this.reply = reply;
        this.functions = functions;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public void setFunctions(List<String> functions) {
        this.functions = functions;
    }

    public String getReply() {
        return reply;
    }

    public List<String> getFunctions() {
        return functions;
    }
    
    
}