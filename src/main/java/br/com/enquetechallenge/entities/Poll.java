package br.com.enquetechallenge.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll extends AbstractEntity{

    @OneToMany(targetEntity=Option.class, mappedBy="poll", fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Option> options;

    @Override
    @JsonProperty("poll_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @JsonProperty("poll_description")
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
