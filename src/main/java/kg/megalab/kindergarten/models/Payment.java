package kg.megalab.kindergarten.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    Integer amount;
    @Column(nullable = false, name = "payment_date")
    LocalDate paymentDate;
    @ManyToOne
    @JoinColumn(name = "group_children_id", nullable = false)
    GroupChildren groupChildren;

}
