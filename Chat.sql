create table chat_talking (
    indexNo number(10) primary key,
    clientName varchar(30),
    msg varchar2(100),
    toDate varchar2(30)
);


create sequence seq_chat_talking
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;