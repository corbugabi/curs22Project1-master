package ro.fasttrackit.curs22Project1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs22Project1.model.entity.Articol;
import ro.fasttrackit.curs22Project1.repository.ArticolRepository;

import java.util.List;

@SpringBootApplication
public class Curs22Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Curs22Project1Application.class, args);
	}

	@Bean
	CommandLineRunner atStartup(ArticolRepository repository){
		return args -> {
			repository.saveAll(List.of(
					new Articol("Mihai Eminescu","poet, prozator și jurnalist român","Scriitor"),
					new Articol("Al Pacino","pactor american de film, scenă și voce, considerat a fi unul dintre cei mai talentați din istoria cinematografiei","Actor"),
					new Articol("Schelet","este o parte a corpului care are rolul de suport sau sprijin a unui organism","Biologie"),
					new Articol("Bătrânul și marea","este un roman scris de Ernest Hemingway","Carti")
			));
		};
	}
}
