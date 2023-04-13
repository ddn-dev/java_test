CREATE TABLE PRICES (
    brand_id bigint not null,
    start_date timestamp not null,
    end_data timestamp not null,
    price_list int not null,
    product_id bigint not null,
    priority int not null,
    price float not null,
    curr varchar not null
);