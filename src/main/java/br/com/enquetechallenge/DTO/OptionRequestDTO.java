package br.com.enquetechallenge.DTO;

import br.com.enquetechallenge.entities.Poll;

public class OptionRequestDTO {

    protected String description;

    public OptionRequestDTO() {}

    public OptionRequestDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
