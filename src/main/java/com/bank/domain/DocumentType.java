package com.bank.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the document_type database table.
 * 
 */
@Entity
@Table(name = "document_type")
@NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "doty_id")
	@NotNull
	@Min(1)
	private Integer dotyId;

	@NotNull
	private Boolean enable;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 200)
	private String name;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "documentType")
	private List<Customer> customers;


}