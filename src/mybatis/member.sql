
-- member���̺���� (no,name,age,job)
-- 연결이 끊어지면 Open Perspective - Database Development - Database Connections를 더블클릭
drop table member;
create table member(
   no    number constraint member_pk primary key,
   name  varchar2(15),
   age   number,
   job   varchar2(15)
);

create sequence member_seq
      start with 1
      increment by 1
      nocycle
      nocache;
      
select * from MEMBER; 
      
      