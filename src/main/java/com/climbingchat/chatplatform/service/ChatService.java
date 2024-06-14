package com.climbingchat.chatplatform.service;

import com.climbingchat.chatplatform.dto.ChatMessageDTO;
import com.climbingchat.chatplatform.model.ChatModelEntity;
import com.climbingchat.chatplatform.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessageDTO> getAllMessages() {
        return chatMessageRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ChatMessageDTO saveMessage(ChatMessageDTO chatMessageDTO) {
        try {
            ChatModelEntity model = new ChatModelEntity();
            model.setSender(chatMessageDTO.getSender());
            model.setContent(chatMessageDTO.getContent());
            model = chatMessageRepository.save(model);
            System.out.println("Saved message: " + model.getContent());
            return convertToDTO(model);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ChatMessageDTO convertToDTO(ChatModelEntity chatMessageModel) {
        ChatMessageDTO dto = new ChatMessageDTO();
        dto.setSender(chatMessageModel.getSender());
        dto.setContent(chatMessageModel.getContent());
        return dto;
    }
}