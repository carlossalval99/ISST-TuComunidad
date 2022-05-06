create table vecino(
    id varchar_ignorecase(50) not null,
    nombre varchar_ignorecase(50) not null,
    piso varchar_ignorecase(50) not null,
    dni varchar_ignorecase(50) not null,
    clave varchar_ignorecase(50) not null
);
create table authorities(
    dni varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_vecino foreign key(dni) references vecino(dni)
);