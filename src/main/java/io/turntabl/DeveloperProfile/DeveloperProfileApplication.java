package io.turntabl.DeveloperProfile;

import io.turntabl.DeveloperProfile.service.ReadJsonFromFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class DeveloperProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperProfileApplication.class, args);
	}

	@Bean
	public ReadJsonFromFile jsonFromFile() {
		return new ReadJsonFromFile();
	}

}
