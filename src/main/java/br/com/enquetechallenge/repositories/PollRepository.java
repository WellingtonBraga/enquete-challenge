package br.com.enquetechallenge.repositories;

import br.com.enquetechallenge.entities.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
    public Poll findByDescription(String description);
}
