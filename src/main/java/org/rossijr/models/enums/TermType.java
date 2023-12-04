package org.rossijr.models.enums;


public enum TermType {
    NOUN("Noun"),
    VERB("Verb"),
    ADJECTIVE("Adjective"),
    ADVERB("Adverb"),
    PRONOUN("Pronoun"),
    PREPOSITION("Preposition"),
    CONJUNCTION("Conjunction"),
    INTERJECTION("Interjection"),
    ARTICLE("Article"),
    NUMERAL("Numeral"),
    PHRASE("Phrase"),
    OTHER("Other");

    private final String name;

    TermType(String name) {
        this.name = name;
    }



}
