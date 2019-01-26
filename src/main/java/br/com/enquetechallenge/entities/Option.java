package br.com.enquetechallenge.entities;

import br.com.enquetechallenge.views.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "description")
    protected String description;

    @ManyToOne
    @JoinColumn(name="poll_id", nullable = false, insertable = true)
    @JsonIgnore
    private Poll poll;

    @Column(name = "qty", columnDefinition = "int default 0")
    private int qty;

    public Option() {
    }

    public Option(String description) {
        this.description = description;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    @JsonProperty("option_id")
    @JsonView({View.Public.class, View.Votes.class, View.Stats.class})
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("option_description")
    @JsonView(View.Public.class)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonView(View.Stats.class)
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
