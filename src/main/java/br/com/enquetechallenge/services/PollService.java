package br.com.enquetechallenge.services;

import br.com.enquetechallenge.DTO.OptionRequestDTO;
import br.com.enquetechallenge.DTO.PollRequestDTO;
import br.com.enquetechallenge.DTO.PollResponseDTO;
import br.com.enquetechallenge.entities.Option;
import br.com.enquetechallenge.entities.Poll;
import br.com.enquetechallenge.entities.Stats;
import br.com.enquetechallenge.exceptions.ResourceNotFoundException;
import br.com.enquetechallenge.repositories.OptionRepository;
import br.com.enquetechallenge.repositories.PollRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    public PollResponseDTO findPollById(Long id) {
        Poll p = pollRepository.findById(id).orElse(null);

        if (p == null) {
            throw new ResourceNotFoundException("Poll not found.");
        }

        p.setViews(p.getViews() + 1);
        pollRepository.save(p);

        PollResponseDTO pollResponseDTO = modelMapper.map(p, PollResponseDTO.class);

        return pollResponseDTO;
    }

    public PollResponseDTO save(PollRequestDTO pollRequestDTO) {

        Poll poll = modelMapper.map(pollRequestDTO, Poll.class);

        for (Option option:
                pollRequestDTO.getOptions()) {
            option.setPoll(poll);
        }

        return modelMapper.map(pollRepository.save(poll), PollResponseDTO.class);
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
