package kg.megalab.kindergarten.repositories;

import kg.megalab.kindergarten.models.GroupChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupChildrenRepo extends JpaRepository<GroupChildren,Long> {
    GroupChildren findByChildIdAndEndDateIsNull(Long id);

    long countByGroupIdAndEndDateIsNull(Long id);
}
