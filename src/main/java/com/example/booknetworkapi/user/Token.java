package com.example.booknetworkapi.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity



public class Token {
    @Id
    private Integer id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime validateAt;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;




    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}
