package com.directrice.contentfeed.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
public class AddContentFeedDTO {

    @NotNull(message = "Title length should be min 6 and max 30.")
    @NotEmpty(message = "Title length should be min 6 and max 30.")
    @Length(min = 6, max = 30, message = "Title length should be min 6 and max 30.")
    private String title;

    @NotNull(message = "Author length should be min 6 and max 30.")
    @NotEmpty(message = "Author length should be min 6 and max 30.")
    @Length(min = 6, max = 30, message = "Author length should be min 6 and max 30.")
    private String author;

    @NotNull(message = "Description length should be min 30 and max 500.")
    @NotEmpty(message = "Description length should be min 30 and max 500.")
    @Length(min = 30, message = "Description length should be min 30 and max 500.")
    private String description;

    private List<String> imagesUrl;
    private List<String> discoverFields;
}
