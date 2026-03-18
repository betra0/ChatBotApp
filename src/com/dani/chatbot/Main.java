
package com.dani.chatbot;
import com.dani.chatbot.ia.impl.GeminiService;
import com.dani.chatbot.ia.AIProvider;
import com.dani.chatbot.ia.AIService;
import com.dani.chatbot.ia.AIServiceFactory;
import com.dani.chatbot.chat.ChatService;




import java.util.Scanner;

/**
 *
 * @author bytrayed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc =new Scanner(System.in);
        
        int intents =5;
        System.out.println("Iniciando Chat con IA");
        AIService ai = AIServiceFactory.create(AIProvider.GEMINI);
        ChatService chat = new ChatService(ai);
                
                
        while(intents >= 1){
            System.out.println("pregunta a la IA: ");
            String entrada= sc.nextLine();
            if(entrada.equals("q")){
                System.out.println("bye bye");
                break;
            }
            System.out.println("Esperando respuesta de la IA...");

            String res = chat.sendMessage(entrada);
            System.out.println(res);
          
          
                  
          
            intents --;
        }
        
    }
    
}
