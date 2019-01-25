package br.com.enquetechallenge.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="poll_id", referencedColumnName = "id", nullable = false)
    private Poll poll;

    public Option(String description) {
        this.description = description;
    }

    @Override
    @JsonProperty("option_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @JsonProperty("option_description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
