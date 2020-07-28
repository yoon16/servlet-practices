desc guestbook;


-- insert
insert into guestbook value(null, '엄지윤', '1234', '안녕하세요~', now());


-- select
select no, name, message, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook;