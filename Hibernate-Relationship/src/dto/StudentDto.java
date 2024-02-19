package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {
    private String name;
    private String address;
    private String lapBrand;
    private String lapModel;
    private Integer batchId;


}
