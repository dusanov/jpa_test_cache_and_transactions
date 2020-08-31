package me.dusanov.jpa.exercise.demo;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface ArticleRepo extends CrudRepository<Article, Integer> {}
