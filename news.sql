create schema news

create table "news".news (
id int primary key not null,
title varchar (100) not null,
datatime date not null,
text_news varchar (1000) not null)
