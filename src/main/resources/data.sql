
INSERT INTO obra (nombre, direccion, descripcion, fecha_inicio, fecha_fin, estado)
VALUES
    ('Reforma edificio Alixar', 'Castilleja de la Cuesta', 'Reforma integral del edificio', '2026-01-15', '2026-12-15', 'En curso'),
    ('Construccion viviendas', 'Sevilla', 'Construccion de viviendas nuevas', '2026-03-01', '2027-03-01', 'En curso'),
    ('Rehabilitacion de oficinas', 'Pilas', 'Mejora de instalaciones y oficinas', '2025-09-01', '2026-06-30', 'Finalizada');

INSERT INTO aviso (tipo, mensaje, fecha, leido, id_obra)
VALUES
    ('Incidencia', 'Retraso en la entrega de materiales', NOW(), FALSE, 1),
    ('Informacion', 'Se ha completado la primera fase', NOW(), TRUE, 1),
    ('Urgente', 'Problema con la instalacion electrica', NOW(), FALSE, 2),
    ('Informacion', 'La obra ha sido finalizada', NOW(), TRUE, 3);
