package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Note {
    private long id;
    private String title;
    private String content;
}
