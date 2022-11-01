package ro.fasttrackit.curs22Project1.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs22Project1.model.entity.Articol;
import ro.fasttrackit.curs22Project1.repository.ArticolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticolService {
    private final ArticolRepository repository;

    public ArticolService(ArticolRepository repository) {
        this.repository = repository;
    }

    public List<Articol> getAll() {
        return repository.findAll();
    }

    public Articol create(Articol newArticol) {
        newArticol.setId(null);
        return repository.save(newArticol);
    }

    public Optional<Articol> replaceArticol(int articolId, Articol articol) {
        return repository.findById(articolId)
                .map(dbArticol -> patchArticol(dbArticol, articol))
                .map(repository::save);
    }

    private Articol patchArticol(Articol dbArticol,Articol articol){
        dbArticol.setName(articol.getName());
        dbArticol.setDescription(articol.getDescription());
        dbArticol.setCategory(articol.getCategory());
        return dbArticol;
    }

    public Articol deleteArticol(int articolId) {
        Optional<Articol> articol = repository.findById(articolId);
        articol.ifPresent(repository::delete);
        return articol.orElse(null);
    }

    public Optional<Articol> getArticol(int articolId){
        return repository.findById(articolId);
    }
}
