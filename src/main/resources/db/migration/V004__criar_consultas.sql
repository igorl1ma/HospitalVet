CREATE SEQUENCE consultas_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE consultas (
id BIGINT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('consultas_id_seq'),
id_medico BIGINT NOT NULL,
nm_medico VARCHAR (60),
id_pet BIGINT NOT NULL,
nm_pet VARCHAR (60),
dt_entrada TIMESTAMP,
dt_saida TIMESTAMP,
retorno BOOLEAN,
unidade_id INTEGER,
FOREIGN KEY (id_medico) REFERENCES medicos (id),
FOREIGN KEY (id_pet) REFERENCES pets (id)
);

