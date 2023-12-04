package org.rossijr.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_example")
public class Example {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "EXAMPLE", nullable = false)
    private String example;
    @ManyToOne @JoinColumn(name = "MEANING_ID", nullable = false)
    private Meaning meaning;

    public Example() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Meaning getMeaning() {
        return meaning;
    }

    public void setMeaning(Meaning meaning) {
        this.meaning = meaning;
    }
}
