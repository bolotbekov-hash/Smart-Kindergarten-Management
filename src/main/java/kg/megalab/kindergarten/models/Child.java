package kg.megalab.kindergarten.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "childrens")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    String patronymic;
    @Column(name = "date_of_birth", nullable = false)
    LocalDate birthDate;
    @OneToMany(mappedBy = "child")
    List<GroupChildren> groupChildren = new ArrayList<>();
}
