package br.com.enquetechallenge.controllers;

import br.com.enquetechallenge.entities.Poll;
import br.com.enquetechallenge.repositories.OptionRepository;
import br.com.enquetechallenge.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private OptionRepository optionRepository;

    @RequestMapping(path = "/{id}")
    public ResponseEntity<?> findPollById(@PathVariable Long id) {
        return new ResponseEntity<>(pollRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Poll poll) {
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(p.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/error")
    public String error() {
        return "Error..";
    }
}
