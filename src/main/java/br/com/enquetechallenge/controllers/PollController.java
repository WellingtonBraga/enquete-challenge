package br.com.enquetechallenge.controllers;

import br.com.enquetechallenge.DTO.PollRequestDTO;
import br.com.enquetechallenge.entities.Poll;
import br.com.enquetechallenge.services.PollService;
import br.com.enquetechallenge.views.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    @RequestMapping(path = "/{id}")
    @JsonView(View.Poll.class)
    public ResponseEntity<?> findPollById(@PathVariable Long id) {
        return new ResponseEntity<>(pollService.findPollById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @JsonView(View.Public.class)
    public ResponseEntity<?> save(@RequestBody PollRequestDTO poll) {
        return new ResponseEntity<>(pollService.save(poll), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}/vote", method = RequestMethod.POST)
    @JsonView(View.Votes.class)
    public ResponseEntity<?> vote(@PathVariable Long id) {
        return pollService.vote(id);
    }

    @RequestMapping(path = "/{id}/stats")
    @JsonView(View.Stats.class)
    public ResponseEntity<?> stats(@PathVariable Long id) {
        return pollService.stats(id);
    }

}
