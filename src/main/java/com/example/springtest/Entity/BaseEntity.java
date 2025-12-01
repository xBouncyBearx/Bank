package com.example.springtest.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "created", nullable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "updated", nullable = false, columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @PrePersist
    protected void onCreate() {
        updateDate = createDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }
}
