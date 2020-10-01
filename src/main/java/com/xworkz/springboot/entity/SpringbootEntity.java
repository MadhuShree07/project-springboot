package com.xworkz.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name="springboot")
@Data
public class SpringbootEntity implements Serializable {
			
			
			@Id
			@GenericGenerator(name = "madhu", strategy = "increment")
			@GeneratedValue(generator="madhu")
			@Column(name="id")
			private int id;
			@Column(name="from_name")
			private String fromName;
			@Column(name="message")
			private String message;
			
			
}
