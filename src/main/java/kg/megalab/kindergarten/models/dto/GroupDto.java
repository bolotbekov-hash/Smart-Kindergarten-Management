package kg.megalab.kindergarten.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {


    Long id;
    String name;
    int maxChildrenCount;
    double price;
    Long nannyId;
    Long groupCategoryId;
    Long teacherId;
}
