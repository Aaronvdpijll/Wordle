create table wordle_daily_attempt (
daily_attempt_id int primary key identity (1,1) not null,
user_id int,
CONSTRAINT user_id
FOREIGN KEY (user_id)
REFERENCES wordle_users(user_id)
)