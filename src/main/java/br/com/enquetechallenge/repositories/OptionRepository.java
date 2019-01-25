package br.com.enquetechallenge.repositories;

import br.com.enquetechallenge.entities.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
}
