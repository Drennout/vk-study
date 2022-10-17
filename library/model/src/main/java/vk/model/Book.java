package vk.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Book {
    private final int id;
    private final String name;
    private final Author author;
}
