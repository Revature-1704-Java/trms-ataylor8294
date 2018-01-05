create table employees(
employeeid integer primary key not null,
firstname varchar2(20) not null,
lastname varchar2(20) not null,
username varchar2(30) not null,
passwords varchar2(20) not null,
email varchar2(30), constraint strlen check (length(passwords) > 6));
create table manager( managerid integer primary key not null, employeeids integer,
constraint employeemanager foreign key (employeeids) references employees(employeeid));
drop table reimburse;
create table reimburse ( reimburseid integer primary key not null,
names varchar2(40), amount integer, employeeid integer,
approved number(1,0) default 0, managerid integer, CONSTRAINT employeereimb FOREIGN KEY (employeeid)
    REFERENCES employees(employeeid), CONSTRAINT managerreimb FOREIGN KEY (managerid)
    REFERENCES manager(managerid));

select * from manager;
select * from employees;
select * from reimburse;
insert into employees values(1,'Andrew', 'Taylor', 'ataylor8294', 'ataylor8294', 'ataylor8294@pointloma.edu');
insert into employees values(2, 'Kevin', 'Jasminne', 'thirsty', 'password', 'kevinj@pointloma.edu');
insert into employees values(3, 'Tim', 'Kuter', 'iamtim', 'password', 'timkuter@revature.com');
insert into manager values(1,1);
insert into manager values(2,2);
insert into reimburse values(1, 'enthuware', 20, 3,0, 1);
select * from reimburse; 
drop table reimburse;
drop table employees;
drop table manager;
create table employees (employeeid integer primary key,
firstname varchar2(30) not null,
lastname varchar2(30) not null,
username varchar2(40) not null,
password varchar2(40) not null,
email varchar2(40) not null,
department integer not null,
reportsto integer,
amountleft number,
constraint employeemanager foreign key (reportsto) references employees(employeeid),
constraint departments foreign key (department) references department(depid));


drop table employees;
drop table departmentmanager;
drop table department;
alter table employees add(amountleft number default(1000));
create table departmentmanager(ids integer primary key,firstname varchar2(20), lastname varchar2(20), username varchar2(40), passwords varchar2(40), email varchar2(30));

create table department(depid integer primary key, names varchar2(20), managerid integer,
constraint managers foreign key (managerid) references departmentmanager(ids) on delete set null);

create table typesofclasses(typeid integer primary key, names varchar2(40) not null, percentavail number);

create table reimburse (reimburseid integer primary key, employeeid integer, dates date, locations varchar2(30), description varchar2(100),
costs integer, typeofclass integer, approvalstage integer, constraint typeofimbursement foreign key (typeofclass) references typesofclasses(typeid), 

constraint typeofemployee foreign key (employeeid) references employees(employeeid));

create table attatchments(attachid integer, filename varchar2(30), reimburseid integer,
constraint reimburseform foreign key (reimburseid) references reimburse(reimburseid));
ALTER TABLE reimburse
MODIFY dates timestamp;


create or replace trigger reimbursedate 
before insert on reimburse for each row
declare
dates timestamp;
begin
    dates:=current_timestamp;
    :new.dates := dates;
end;
/

insert into departmentmanager values (1, 'Ben','co','Benco','ultimate','benco@benco.com');
insert into departmentmanager values (2, 'Andrew','Taylor','ataylor8294','ataylor8294','ataylor8294@benco.com');
insert into  departmentmanager values (3, 'Ryan', 'Taylor', 'rtaylor8294','rtaylor8294','rtaylor8294@benco.com');
insert into departmentmanager values (4, 'Kevin', 'Jasminne', 'kjasmine8294','kjasmine8294','kjasmine8294@benco.com');
insert into departmentmanager values (5, 'Metthew','Johnson', 'mjohnson8294','mjohnson8294','mjohnson8294@benco.com');
insert into department values(2, 'Sales', 3);
insert into department values(1, 'IT', 2);
insert into department values(3, 'Marketing', 3);
insert into department values(4, 'Human Resources',4);
insert into department values(5, 'Engineering', 5);
insert into employees values(1, 'Mehrab', 'Rahman', 'mehrab8294', 'mehrab8294','mehrab8294@benco.com',1,default,default);
insert into employees values(2, 'Aaron','Rodgers', 'arodgers8294', 'arodgers8294','arodgers8294@benco.com',2,1,default);
insert into employees values(3, 'Cam','Newton','cnewton8294','cnewton8294','cnewton8294@benco.com',1,2,default);
insert into typesofclasses values(1, 'University Courses', 90);
insert into typesofclasses values(2, 'Seminars', 60);
insert into typesofclasses values(3, 'Certification Preparation Classes', 75);
insert into typesofclasses values(4, 'Certificationns', 100);
insert into typesofclasses values(5, 'Technical Training', 90);
insert into typesofclasses values(6, 'Other', 30);
Select * from reimburse;
insert into reimburse values (null, 1, null,  'This is a location', 'This is a description', 1000, 1, 1);
Select * from reimburse r where 2=r.employeeid;
select * from reimburse;
CREATE SEQUENCE reimb_seq START WITH 1;
CREATE OR REPLACE TRIGGER dept_bir 
BEFORE INSERT ON reimburse 
FOR EACH ROW

BEGIN
  SELECT reimb_seq.NEXTVAL
  INTO   :new.reimburseid
  FROM   dual;
END;
/
Delete from reimburse;
insert into reimburse values()
commit;
