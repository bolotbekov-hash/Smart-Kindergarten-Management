package kg.megalab.kindergarten.services.impl;

import kg.megalab.kindergarten.models.dto.GroupCategoryCreateDto;
import kg.megalab.kindergarten.models.dto.GroupCategoryDto;
import kg.megalab.kindergarten.response.GlobalResponse;
import kg.megalab.kindergarten.services.GroupCategoryService;
import org.springframework.http.ResponseEntity;

public class GroupCategoryServiceImpl implements GroupCategoryService {
    @Override
    public ResponseEntity<GlobalResponse> createGroupCategory(GroupCategoryCreateDto groupCategoryCreateDto) {
        return null;
    }

    @Override
    public ResponseEntity<GlobalResponse> updateGroupCategory(GroupCategoryDto groupCategoryDto, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<GlobalResponse> deleteGroupCategory(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<GlobalResponse> findCategoryGroupById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<GlobalResponse> findAllCategoryGroup(int pageNo, int pageSize) {
        return null;
    }
}
