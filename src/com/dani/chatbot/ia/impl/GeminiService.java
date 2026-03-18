
package com.dani.chatbot.ia.impl;

import com.dani.chatbot.ia.AIRequest;
import com.dani.chatbot.ia.AIResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import com.dani.chatbot.ia.AIService;

/**
 *
 * @author bytrayed
 */
public class GeminiService implements AIService {
        
    static String apiKey = "clave a usar aqui";
    
    static String sendPrompt (String prompt){
        HttpClient client = HttpClient.newHttpClient();
        
        String jsonRequest = """
        {
          "contents": [{
            "parts":[{"text": "%s"}]
          }]
        }
        """.formatted(prompt);
        
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent"))
                    .header("Content-Type", "application/json")
                    .header("x-goog-api-key", apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Respuesta de Gemini:");
            
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            
            String text = json
                    .getAsJsonArray("candidates")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("content")
                    .getAsJsonArray("parts")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString();
            
            //System.out.println(text);
            return text;
            

        } catch (Exception e) {
            System.out.println("Error al conectar con Gemini: " + e.getMessage());
        }
        return null;
        
         
    }

    @Override
    public AIResponse sendMessage(AIRequest request) {
        String res = sendPrompt(request.getMessage());
        return new AIResponse(res, null);
        
    }
    

}
