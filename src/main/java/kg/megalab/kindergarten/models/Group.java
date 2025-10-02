package kg.megalab.kindergarten.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Group {
    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false, name = "max_children_count")
    Integer maxChildren;
    Double price;
    @ManyToOne
    @JoinColumn(name = "nanny_id")
    Teacher nanny;
    @ManyToOne
    @JoinColumn(name = "group_category_id")
    GroupCategory groupCategory;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @OneToMany
    @JsonIgnore
    List<GroupChildren> groupChildren = new ArrayList<>();


}
