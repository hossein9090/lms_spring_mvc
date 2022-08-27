package ir.hossein.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowModel {
    private Integer id;
    private Integer userId;
    private Integer bookId;
}
