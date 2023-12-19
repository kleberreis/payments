create table payments (
    id bigserial primary key,
    product_key varchar(100) not null,
    ad_id varchar(100) not null,
    account_id varchar(100) not null,
    status varchar(100) not null,
    order_id int not null,
    price numeric not null,
    uuid varchar(100) not null
);