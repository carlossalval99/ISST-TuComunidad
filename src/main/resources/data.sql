insert into vecino(id, clave, dni, nombre, piso) values ('1','{noop}vecino1','12345678A','pepe', '1A');
insert into vecino(id, clave, dni, nombre, piso) values ('2','{noop}vecino2','12345678B','juan', '1B');

insert into authorities(dni, authority) values ('12345678A', 'ROLE_PRESIDENTE');

insert into authorities(dni, authority) values ('12345678B', 'ROLE_VECINO');
