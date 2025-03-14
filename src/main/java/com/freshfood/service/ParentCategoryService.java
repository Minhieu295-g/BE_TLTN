package com.freshfood.service;

import com.freshfood.dto.request.ParentCategoryRequestDTO;
import com.freshfood.dto.response.PageResponse;
import com.freshfood.model.ParentCategory;

public interface ParentCategoryService {
    int saveParentCategory(ParentCategoryRequestDTO parentCategoryRequestDTO, String imageUrl);
    void updateParentCategory(int id, ParentCategoryRequestDTO parentCategoryRequestDTO, String imageUrl);
    void deleteParentCategory(int id);
    PageResponse getParentCategory(int pageNo, int pageSize);

    ParentCategory getParentCategoryById(int id);
}
