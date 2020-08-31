package me.dusanov.jpa.exercise.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="articles")
@Entity
public class Article {
	
	@Id	
	private Integer articleId;
	private String articleTitle;
	@Column(name="article_short_desc")
	private String articleDesc;
	private int articleType;
	//todo: this is clob
	private String articleText;
	//private Clob articleText;
	private String articleImage;
	/*
	created_by INT,
	created_on TIMESTAMP NOT NULL,
    modified_by INT,
	modified_on TIMESTAMP
	 */
}
