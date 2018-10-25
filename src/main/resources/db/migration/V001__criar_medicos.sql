CREATE SEQUENCE medicos_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;

CREATE TABLE medicos (
id BIGINT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('medicos_id_seq'),
nm_medico VARCHAR (60) NOT NULL,
especialidades VARCHAR (300) NOT NULL
);

INSERT INTO medicos (nm_medico,especialidades) VALUES ('Igor da Silva Lima','Cardiologista');
INSERT INTO medicos (nm_medico,especialidades) VALUES ('Amanda Souza Tibães','Cirurgiã');