
DROP TABLE IF EXISTS aviso;
DROP TABLE IF EXISTS obra;

CREATE TABLE obra (
                      id_obra BIGINT AUTO_INCREMENT PRIMARY KEY,
                      nombre VARCHAR(100) NOT NULL,
                      direccion VARCHAR(200) NOT NULL,
                      descripcion TEXT,
                      fecha_inicio DATE NOT NULL,
                      fecha_fin DATE,
                      estado VARCHAR(30) NOT NULL
);

CREATE TABLE aviso (
                       id_aviso BIGINT AUTO_INCREMENT PRIMARY KEY,
                       tipo VARCHAR(50) NOT NULL,
                       mensaje VARCHAR(500) NOT NULL,
                       fecha DATETIME NOT NULL,
                       leido BOOLEAN NOT NULL DEFAULT FALSE,
                       id_obra BIGINT NOT NULL,

                       CONSTRAINT fk_aviso_obra
                           FOREIGN KEY (id_obra)
                               REFERENCES obra(id_obra)
);
