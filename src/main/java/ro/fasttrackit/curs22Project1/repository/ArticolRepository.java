package ro.fasttrackit.curs22Project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs22Project1.model.entity.Articol;

public interface ArticolRepository extends JpaRepository<Articol, Integer> {
}
