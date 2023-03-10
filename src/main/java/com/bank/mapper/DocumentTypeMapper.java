package com.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bank.domain.DocumentType;
import com.bank.dto.DocumentTypeDTO;

@Mapper
public interface DocumentTypeMapper {

	public DocumentTypeDTO toDocumentTypeDTO(DocumentType documentType);

	public DocumentType toDocumentType(DocumentTypeDTO documentTypeDTO);

	public List<DocumentTypeDTO> toDocumentTypeDTOs(List<DocumentType> documentTypes);

	public List<DocumentType> toDocumentTypes(List<DocumentTypeDTO> documentTypeDTOs);

}
