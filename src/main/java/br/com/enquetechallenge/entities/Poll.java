package br.com.enquetechallenge.entities;

import br.com.enquetechallenge.views.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "polls")
public class Poll{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "description")
    protected String description;

    @OneToMany(targetEntity=Option.class, mappedBy="poll", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option> options;

    @Column(name = "views")
    protected int views;

    public Poll() {
    }

    public Poll(List<Option> options) {
        this.options = options;
    }

    @JsonProperty("poll_id")
    @JsonView(View.Public.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("poll_description")
    @JsonView(View.Poll.class)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonView(View.Poll.class)
    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(id, option.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
