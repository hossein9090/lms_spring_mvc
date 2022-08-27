package ir.hossein.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Integer id;
    private String fName;
    private String lName;
    private String address;
}
