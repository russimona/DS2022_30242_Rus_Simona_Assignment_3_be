package ro.tuc.ds2020.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import ro.tuc.ds2020.controllers.model.Message;

public class ChatController {
private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")  // /app/message
    @SendTo("/chat/public")
    private Message receivedPublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message){
        this.simpMessagingTemplate.convertAndSendToUser(message.getReceiverEmail(),"/private",message);
        System.out.println(message.toString());
        return message;
    }

}
