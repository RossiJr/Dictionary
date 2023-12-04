package org.rossijr.models;

import jakarta.persistence.*;
import org.rossijr.models.enums.Article;
import org.rossijr.models.enums.TermType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_term")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "ORIGINAL_TERM", nullable = false)
    private String originalTerm;
    @Column(name = "TYPE", nullable = false)
    private TermType type;
    @Column(name = "ARTICLE")
    private Article article;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "IS_PLURAL", nullable = false)
    private Boolean isPlural;
    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private List<Meaning> meanings = new ArrayList<>();


    public Term() {
    }

    public Term(String originalTerm, TermType type, boolean isPlural){
        this.originalTerm = originalTerm;
        this.type = type;
        this.isPlural = isPlural;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTerm() {
        return originalTerm;
    }

    public void setOriginalTerm(String originalTerm) {
        this.originalTerm = originalTerm;
    }

    public TermType getType() {
        return type;
    }

    public void setType(TermType type) {
        this.type = type;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getPlural() {
        return isPlural;
    }

    public void setPlural(Boolean plural) {
        isPlural = plural;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", originalTerm='" + originalTerm + '\'' +
                '}';
    }
}
