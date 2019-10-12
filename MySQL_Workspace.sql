USE sample;
Select * from student;
Drop table student;

Create table student(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(12) NOT NULL,
course VARCHAR(12) NOT NULL,
PRIMARY KEY (id)
);
insert into student(name, course) values ("Ashutosh", "SER 501");
insert into student(name, course) values ("Prakhar", "SER 501");
UPDATE student 
SET 
    name = 'mary.patterson@classicmodelcars.com',
    course = 'SER 566'
WHERE
    id = 1056;
insert into student(id, name, course) values (5,"Nachi", "SER 522");
