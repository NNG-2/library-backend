package com.documentation.library.mappers;

import com.documentation.library.domains.Category;
import com.documentation.library.dtos.CategoryDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category entity);

    @InheritInverseConfiguration
    Category toEntity(CategoryDto dto);

    List<CategoryDto> toDtoList(List<Category> entities);

    @InheritInverseConfiguration
    List<Category> toEntityList(List<CategoryDto> dtoList);
}