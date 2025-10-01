package kg.megalab.kindergarten.models.dto;

import kg.megalab.kindergarten.models.Group;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCategoryDto {
    Long id;
    String name;
    boolean active;
    double price;


}
