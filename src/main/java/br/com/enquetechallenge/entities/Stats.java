package br.com.enquetechallenge.entities;

import br.com.enquetechallenge.views.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.annotation.Resource;
import java.util.List;

@Resource
public class Stats {

    private int views;

    private List<Option> votes;

    public Stats(int views, List<Option> votes) {
        this.views = views;
        this.votes = votes;
    }

    @JsonView(View.Stats.class)
    public int getViews() {
        return views;
    }

    @JsonView(View.Stats.class)
    public List<Option> getVotes() {
        return votes;
    }
}
