CREATE SEQUENCE pets_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE pets (
id BIGINT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('pets_id_seq'),
nm_pet VARCHAR (60) NOT NULL,
nm_dono VARCHAR (60) NOT NULL,
sexo CHAR NOT NULL,
telefone VARCHAR (20) NOT NULL,
celular VARCHAR (20) NOT NULL,
idade INTEGER NOT NULL
);

