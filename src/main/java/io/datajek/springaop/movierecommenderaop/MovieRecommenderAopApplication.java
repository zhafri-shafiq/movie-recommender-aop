package io.datajek.springaop.movierecommenderaop;

import io.datajek.springaop.movierecommenderaop.business.FilteringTechnique1;
import io.datajek.springaop.movierecommenderaop.business.FilteringTechnique2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderAopApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FilteringTechnique1 filteringTechnique1;

	@Autowired
	private FilteringTechnique2 filteringTechnique2;

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommenderAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("{}", filteringTechnique1.contentBasedFiltering());
		logger.info("{}", filteringTechnique2.collaborativeFiltering());
	}
}
