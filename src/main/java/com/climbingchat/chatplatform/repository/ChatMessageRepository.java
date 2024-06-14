package com.climbingchat.chatplatform.repository;

import com.climbingchat.chatplatform.model.ChatModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatModelEntity, UUID> {
}
