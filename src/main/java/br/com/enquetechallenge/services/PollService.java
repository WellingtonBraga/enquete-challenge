package br.com.enquetechallenge.services;

import br.com.enquetechallenge.entities.Option;
import br.com.enquetechallenge.entities.Poll;
import br.com.enquetechallenge.entities.Stats;
import br.com.enquetechallenge.exceptions.ResourceNotFoundException;
import br.com.enquetechallenge.repositories.OptionRepository;
import br.com.enquetechallenge.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    public ResponseEntity<?> findPollById(Long id) {
        Poll p = pollRepository.findById(id).orElse(null);

        if (p == null) {
            throw new ResourceNotFoundException("Poll not found.");
        }

        p.setViews(p.getViews() + 1);
        pollRepository.save(p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    public ResponseEntity<?> save(Poll poll) {
        for (Option option:
                poll.getOptions()) {
            option.setPoll(poll);
        }

        return new ResponseEntity<>(pollRepository.save(poll), HttpStatus.OK);
    }

    public ResponseEntity<?> vote(Long id) {
        Option option = optionRepository.findById(id).orElse(null);

        if (option == null) {
            throw new ResourceNotFoundException("Option not found.");
        }

        option.setQty(option.getQty() + 1);

        return new ResponseEntity<>(optionRepository.save(option), HttpStatus.OK);
    }

    public ResponseEntity<?> stats(Long id) {
        Poll p = pollRepository.findById(id).orElse(null);

        if (p == null) {
            throw new ResourceNotFoundException("Stats Poll not found.");
        }

        Stats stats = new Stats(p.getViews(), p.getOptions());

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

}
