package tw.yzli;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)
public class DemoSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootProjectApplication.class, args);
	}

	
}
