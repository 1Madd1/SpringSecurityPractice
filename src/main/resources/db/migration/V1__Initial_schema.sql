create table if not exists public.users (
    id UUID not null,
    username VARCHAR(50) not null,
    password text not null,
    primary key (id)
);