package com.example.youtubepopularityrank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Video {
    private String thumbnail;
    private String title;
    private String url;
    private String description;
}
