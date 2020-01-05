package com.ubs.teste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "data")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	
	@Column
    private String product;

	@Column
	private int quantity;
	
	@Column
	private String price;

	@Column
    private String type;
	
	@Column
    private String industry;
	
	@Column
    private String origin;
	
}
