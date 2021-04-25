create table chat_talking (
    chatName varchar2(40) primary key,
    chat varchar2(100),
    chatDate date
);

drop table chat_talking;
drop sequence seq_chat_talking;


create sequence seq_chat_talking
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
    
    
-- insert into chat_talking values ('kosmo', 'hi', '2021-04-25');