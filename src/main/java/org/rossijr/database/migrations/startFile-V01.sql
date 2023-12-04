drop TABLE IF EXISTS tb_example;
drop TABLE IF EXISTS tb_meaning;
drop TABLE IF EXISTS tb_term;

create table tb_term
(
    ID            INTEGER primary key autoincrement not null,
    ORIGINAL_TERM text                              not null,
    TYPE          text                              not null,
    ARTICLE       text,
    IS_PLURAL      blob                              not null,
    LANGUAGE      text
);

create table tb_meaning
(
    ID         INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    TERM_ID    INTEGER                           NOT NULL,
    MEANING    TEXT                              NOT NULL,
    ENTRY_DATE TEXT                              NOT NULL,
    foreign key (TERM_ID) references tb_term (ID)
);

create table tb_example
(
    ID         INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    MEANING_ID INTEGER                           NOT NULL,
    EXAMPLE    TEXT                              NOT NULL,
    foreign key (MEANING_ID) references tb_meaning (ID)
);
