package com.directrice.contentfeed.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AddContentFeedDTO {

    private String title;
    private String author;
    private String description;
    private List<String> imagesUrl;
    private List<String> discoverFields;
}
