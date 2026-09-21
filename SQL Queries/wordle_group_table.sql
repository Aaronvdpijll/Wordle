DROP TABLE IF EXISTS wordle_devices;
Drop table if exists wordle_attempt;
DROP TABLE IF EXISTS wordle_users;
drop table if exists wordle_group;

create table wordle_group (
group_id int primary key Identity (1,1) not null,
group_name varchar(20) not null,
group_code char(6)
);

insert into wordle_group(group_name,group_code)
values ('Personal test group','ABCDEF');

select * from wordle_group;
