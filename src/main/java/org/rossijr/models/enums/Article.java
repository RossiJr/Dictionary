package org.rossijr.models.enums;

public enum Article {
    FEMININE("die"),
    MASCULINE("der"),
    NEUTRAL("das");

    private final String name;

    Article(String name) {
        this.name = name;
    }


}
