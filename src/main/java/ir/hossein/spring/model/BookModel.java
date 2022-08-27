package ir.hossein.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

    private Integer id;
    private String name;
    private String authorName;
}
