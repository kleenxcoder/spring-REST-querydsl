package at.stritzingerit.demo.springdatawebh2demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("at.stritzinger-it.*")
@EntityScan("at.stritzingerit.demo.springdatawebh2demo.entity")
@EnableJpaRepositories("")
public class ApplicationConfig {
}
