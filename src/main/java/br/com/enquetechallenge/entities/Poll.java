package br.com.enquetechallenge.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
