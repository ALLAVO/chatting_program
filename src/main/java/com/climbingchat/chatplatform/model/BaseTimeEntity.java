package com.climbingchat.chatplatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeEntity {
    @Column(name = "created_at")
    private long createdAt;

    @Column(name = "updated_at")
    private  long updatedAt;

    @PrePersist
    protected void onCreate() {
        long now = Instant.now().getEpochSecond();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}
