package com.bank.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentTypeDTO {

	@NotNull
	@Min(1)
	private Integer dotyId;

	@NotNull
	private Boolean enable;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 200)
	private String name;

	@NotNull
	@Min(0)
	private Integer custId;

}
