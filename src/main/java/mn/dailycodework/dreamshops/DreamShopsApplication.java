package mn.dailycodework.dreamshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DreamShopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamShopsApplication.class, args);
	}

}
