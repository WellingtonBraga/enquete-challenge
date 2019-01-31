package br.com.enquetechallenge.DTO;

import br.com.enquetechallenge.views.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

@JsonView(View.Poll.class)
public class PollResponseDTO {

    @JsonProperty("poll_id")
    protected Long id;

    @JsonProperty("poll_description")
    protected String description;

    private List<OptionResponseDTO> options;

    public PollResponseDTO() { }

    public PollResponseDTO(Long id, String description, List<OptionResponseDTO> options) {
        this.id = id;
        this.description = description;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OptionResponseDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionResponseDTO> options) {
        this.options = options;
    }
}
