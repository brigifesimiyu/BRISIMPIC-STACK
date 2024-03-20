package com.ls.diary.model;

import com.ls.diary.dto.CaseDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.persistence.Entity;

@Entity
@Mapper
public interface CaseMapper {
    CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);

    CaseDto toDTO(Case acase);
    Case toEntity(CaseDto caseDTO);
}
