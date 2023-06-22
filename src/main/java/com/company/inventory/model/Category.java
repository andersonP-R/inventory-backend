package com.company.inventory.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//We use annotations to describe what kind of class is this. Here we define Category class as an
// @Entity so that it's how this class will be save it on our db_inventory
// @Table it's just to define the name of the table in our db_invetory

@Data
@Entity
@Table(name="category")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4310027227752446841L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
}
