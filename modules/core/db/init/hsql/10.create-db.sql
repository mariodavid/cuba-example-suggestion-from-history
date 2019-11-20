-- begin CESFH_PERSON
create table CESFH_PERSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    FIRST_NAME varchar(255),
    STREET varchar(255),
    POSTAL_CODE varchar(255),
    CITY varchar(255),
    ROLE varchar(255),
    --
    primary key (ID)
)^
-- end CESFH_PERSON
