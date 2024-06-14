package com.climbingchat.chatplatform.controller;

import com.climbingchat.chatplatform.dto.ChatMessageDTO;
import com.climbingchat.chatplatform.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/messages")
    public List<ChatMessageDTO> getAllMessages() {
        return chatService.getAllMessages();
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessageDTO sendMessage(ChatMessageDTO chatMessageDTO) {
        try {
            System.out.println("Received message: " + chatMessageDTO.getContent());
            return chatService.saveMessage(chatMessageDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/messages")
    public ChatMessageDTO saveMessage(@RequestBody ChatMessageDTO chatMessageDTO) {
        try {
            System.out.println("Saving message: " + chatMessageDTO.getContent());
            return chatService.saveMessage(chatMessageDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
