package me.dusanov.jpa.exercise.demo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private final ArticleRepo articleRepo;
	
	@Autowired
	public DemoApplication(ArticleRepo articleRepo) {
		this.articleRepo = articleRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Optional<Article> oa1 = articleRepo.findById(7);	
		Optional<Article> oa2 = articleRepo.findById(7);
		
		Assert.isTrue(oa1.get() == oa2.get(), "oa1 not equal to oa2 !");
		oa1.get().setArticleDesc("new description");
		
		System.out.println(oa1.get().toString());
		System.out.println(oa2.get().toString());
		
		Assert.isTrue(oa1.get() == oa2.get(), "oa1 not equal to oa2 !");
		
		// no need for this since teh object is in persistent state
		// and under hibernate session
		// so hibernate will sync automatically
		//articleRepo.save(oa1.get());
		
	}
}