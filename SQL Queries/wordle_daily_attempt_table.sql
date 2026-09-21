drop table  if exists wordle_attempt;

create table wordle_attempt (
daily_attempt_id int primary key identity (1,1) not null,
user_id int,
CONSTRAINT user_id
FOREIGN KEY (user_id)
REFERENCES wordle_users(user_id),
word1 varchar(5),
word2 varchar(5),
word3 varchar(5),
word4 varchar(5),
word5 varchar(5),
word6 varchar(5),
score int,
game_type int,
correct_word varchar(5)
);

select * from wordle_attempt;