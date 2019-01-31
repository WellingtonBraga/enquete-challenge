package br.com.enquetechallenge.DTO;

import br.com.enquetechallenge.entities.Option;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PollRequestDTO {

    @JsonProperty("poll_description")
    protected String description;

    private List<Option> options;

    public PollRequestDTO() {}

    public PollRequestDTO(String description, List<Option> options) {
        this.description = description;
        this.options = options;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
