package com.climbingchat.chatplatform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "chat_message") // 테이블 이름 명시적으로 설정
public class ChatModelEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String sender;
    private String content;
}