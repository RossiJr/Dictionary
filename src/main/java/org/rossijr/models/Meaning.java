package org.rossijr.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_meaning")
public class Meaning {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "MEANING", nullable = false)
    private String meaning;
    @Column(name = "ENTRY_DATE", nullable = false)
    private String entryDate;
    @ManyToOne @JoinColumn(name = "TERM_ID", nullable = false)
    private Term term;
    @OneToMany(mappedBy = "meaning", cascade = CascadeType.ALL)
    private List<Example> examples = new ArrayList<>();

    public Meaning() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }
}
