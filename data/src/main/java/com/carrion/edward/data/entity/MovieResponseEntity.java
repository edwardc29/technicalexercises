package com.carrion.edward.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponseEntity {
    @JsonProperty("total_results")
    private int totalResults;
    @JsonProperty("results")
    private List<MovieEntity> results;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}
