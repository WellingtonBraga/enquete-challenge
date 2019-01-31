package br.com.enquetechallenge.DTO;

import br.com.enquetechallenge.entities.Poll;
import br.com.enquetechallenge.views.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@JsonView(View.Public.class)
public class OptionResponseDTO {

    @JsonProperty("option_id")
    @JsonView({View.Public.class, View.Votes.class, View.Stats.class})
    private Long id;

    @JsonProperty("option_description")
    private String description;

    @JsonIgnore
    private Poll poll;

    public OptionResponseDTO() { }

    public OptionResponseDTO(Long id, String description, Poll poll, int qty) {
        this.id = id;
        this.description = description;
        this.poll = poll;
        this.qty = qty;
    }

    @JsonView(View.Stats.class)
    private int qty;

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

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
