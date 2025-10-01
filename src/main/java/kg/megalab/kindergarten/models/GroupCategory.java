package kg.megalab.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "group_categories")
public class GroupCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String name;
    @Column(nullable = false)
    boolean active;
    @Column(nullable = false, name = "price")
    double price;
    @JsonIgnore
    @OneToMany(mappedBy = "groupCategory")
    List<Group> groups = new ArrayList<>();
}
