package clinica.odontologica;


import org.apache.log4j.PropertyConfigurator;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class OdontologicaApplication {


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(OdontologicaApplication.class, args);
	}

}
