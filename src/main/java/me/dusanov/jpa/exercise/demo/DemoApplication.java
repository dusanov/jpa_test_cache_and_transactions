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
	
	//@Autowired
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
		
		Assert.isTrue(oa1.get() == oa2.get(), " ref compare1: oa1 not equal to oa2 !");
		Assert.isTrue(oa1.get().equals(oa2.get()), " obj compare1: oa1 not equal to oa2 !");
		Assert.isTrue(
				oa1.get().getArticleDesc()
					.equals(oa2.get().getArticleDesc()), 
				"field compare1: oa1 desc not 1 equal to oa2 desc !");
		
		//do a change
		oa1.get().setArticleDesc("new description");
		
		System.out.println(oa1.get().toString());
		System.out.println(oa2.get().toString());
		
		Assert.isTrue(oa1.get() == oa2.get(), " ref compare2: oa1 not equal to oa2 !");
		Assert.isTrue(oa1.get().equals(oa2.get()), " obj compare2: oa1 not equals to oa2 !");
		Assert.isTrue(
				oa1.get().getArticleDesc()
					.equals(oa2.get().getArticleDesc()), 
				"field compare2: oa1 desc not 2 equal to oa2 desc !");

		
		// no need for this since teh object is in persistent state
		// and under hibernate session
		// so hibernate will sync automatically
		
		//articleRepo.save(oa1.get());
		
	}
}