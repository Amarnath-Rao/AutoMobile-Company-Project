CREATE TABLE Vehicle (
    V_id Varchar(10) PRIMARY KEY,
    V_age INT NOT NULL,
    Price NUMERIC(20,3) NOT NULL,
    Dealer_id  Varchar(10) NOT NULL,
    Modify_id  Varchar(10) NOT NULL,
    Type_id  Varchar(10) NOT NULL,
    FOREIGN KEY (Dealer_id) REFERENCES Dealer (Dealer_id) ON DELETE CASCADE,
    FOREIGN KEY (Modify_id) REFERENCES Modify (Modify_id) ON DELETE CASCADE,
    FOREIGN KEY (Type_id) REFERENCES CarType (Type_id) ON DELETE CASCADE
);

CREATE TABLE Dealer (
    Dealer_id  Varchar(10) PRIMARY KEY,
    D_fname VARCHAR(50) ,
    D_lname VARCHAR(50),
    D_Phn VARCHAR(15) NOT NULL,
    D_Email VARCHAR(100) NOT NULL
);

CREATE TABLE Modify (
    Modify_id  Varchar(10) PRIMARY KEY,
    Colour VARCHAR(20) NOT NULL,
    Fuel VARCHAR(20) NOT NULL,
    Seats INT NOT NULL
);

CREATE TABLE CarType (
    Type_id  Varchar(10) PRIMARY KEY,
    Type_name VARCHAR(50),
    Brand_name VARCHAR(50) NOT NULL,
    Model_name VARCHAR(50) NOT NULL,
    Year_of_release INT
);

CREATE TABLE Ordered_Customer (
    Order_id VARCHAR(10) PRIMARY KEY,
    C_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (C_id) REFERENCES Customer (C_id) ON DELETE CASCADE
);

CREATE TABLE Customer (
    C_id VARCHAR(10) PRIMARY KEY,
    C_fname VARCHAR(50),
    C_lname VARCHAR(50),
    C_phno VARCHAR(15) NOT NULL,
    C_Email VARCHAR(100) NOT NULL,
    C_Age INT NOT NULL
);


CREATE TABLE Ordered_Quantity (
    Order_id VARCHAR(10) PRIMARY KEY,
    Order_Quantity INT NOT NULL,
    V_id Varchar(10) NOT NULL,
    FOREIGN KEY (Order_id) REFERENCES Ordered_Customer (Order_id) ON DELETE CASCADE,
    FOREIGN KEY (V_id) REFERENCES Vehicle (V_id) ON DELETE CASCADE
);
insert into Customer(C_id,C_fname,C_lname,C_phno,C_Email,C_Age)   
            values('C1','Subbarao','Mannam','9347089566','mannamsubbarao72@gmail.com',59),
			      ('C2','Charan','Teja','8923213456','charanteja72@gmail.com',27),
				  ('C3','Amarnath','Rao','8888089566','amarnathrao@gmail.com',44),
				  ('C4','Mahesh','kumar','8321237456','maheshkumarchinta@gmail.com',69),
				  ('C5','Vamshidhar','Reddy','7321236543','vamshi@gmail.com',34),
				  ('C6','Hemanth','Laksman','8432345668','Hemanth@gmail.com',22),
				  ('C7','Bhargava','sai','3456789123','bhargava@gmail.com',66),
				  ('C8','yashwant','p','9938229988','yashwant@gmail.com',33),
				  ('C9','Vikranth','k','9345670567','vikranth@gmail.com',43),
				  ('C10','kowshik','kumar','6543212345','kowshik@gmail.com',29);
insert into Customer(C_id,C_fname,C_lname,C_phno,C_Email,C_Age)   
            values('C1','Subbarao','Mannam','9347089566','mannamsubbarao72@gmail.com',59),
			      ('C2','Charan','Teja','8923213456','charanteja72@gmail.com',27),
				  ('C3','Amarnath','Rao','8888089566','amarnathrao@gmail.com',44),
				  ('C4','Mahesh','kumar','8321237456','maheshkumarchinta@gmail.com',69),
				  ('C5','Vamshidhar','Reddy','7321236543','vamshi@gmail.com',34),
				  ('C6','Hemanth','Laksman','8432345668','Hemanth@gmail.com',22),
				  ('C7','Bhargava','sai','3456789123','bhargava@gmail.com',66),
				  ('C8','yashwant','p','9938229988','yashwant@gmail.com',33),
				  ('C9','Vikranth','k','9345670567','vikranth@gmail.com',43),
				  ('C1','kowshik','kumar','6543212345','kowshik@gmail.com',29);
insert into Dealer(Dealer_id,D_fname,D_lname,D_phn,D_Email)   
            values('D1','robert','Baratheon','9347089566','robert@gmail.com'),
			      ('D2','Stannis','Baratheon','8923213456','Stannis@gmail.com'),
				  ('D3','Jon','snow','8888089566','Jon@gmail.com'),
				  ('D4','Danearys','Targareyn','8321237456','Danearys@gmail.com'),
				  ('D5','Arya','Stark','7321236543','Arya@gmail.com'),
				  ('D6','Eddard','Stark','8432345668','Eddard@gmail.com'),
				  ('D7','White','walker','3456789123','White@gmail.com'),
				  ('D8','tyrion','lannister','9938229988','tyrion@gmail.com'),
				  ('D9','jamie','lannister','9345670567','jamie@gmail.com'),
				  ('D10','robb','stark','6543212345','robb@gmail.com');
insert into Modify(modify_id,colour,fuel,seats)
            values('M1','BLACK','ELECTRIC',7),
			      ('M2','RED','DIESEL',2),
				  ('M3','YELLOW','PETROL',5),
				  ('M4','BROWN','ELECTRIC',2),
				  ('M5','PURPLE','DIESEL',6),
				  ('M6','GRAY','ELECTRIC',5),
				  ('M7','WHITE','DIESEL',2),
				  ('M8','MATTE BLACK','DIESEL',7),
				  ('M9','GREEN','ELECTRIC',4),
				  ('M10','PINK','PETROL',7);
insert into cartype(type_id,brand_name,type_name,model_name,year_of_release) 
            values('CT1','AUDI','Q5','SEDAN',2009),
			       ('CT2','TATA','INDICA','COUPE',2015),
				   ('CT3','BENZ','A9','SPORT',2016),
				   ('CT4','VOLVO','VOLT','WAGON',2017),
				   ('CT5','AUDI','Q8','SPORT',2019),
				   ('CT6','FERRARI','FURIOS','CONVERTIBLE',1999),
				   ('CT7','LAMBORGHINI','L5','SPORTS',2011),
				   ('CT8','AUDI','Q7','SUV',2019),
				   ('CT9','SUPRA','SUII','SUV',2020),
				   ('CT10','TATA','NANO','SMALL',2005);
insert into vehicle(v_id,v_age,price,dealer_id,type_id,modify_id) 
             VALUES('V1',3,3000000.23,'D2','CT10','M6'),
			        ('V2',1,9000000.33,'D1','CT3','M7'),
					('V3',9,9900000.23,'D9','CT2','M1'),
					('V4',12,8800000.43,'D10','CT9','M3'),
					('V5',3,4400000.43,'D1','CT8','M2'),
					('V6',22,1100000.232,'D4','CT1','M4'),
					('V7',5,2100000.21,'D5','CT2','M5'),
					('V8',1,4000000.24,'D6','CT5','M9'),
					('V9',9,1000000.21,'D8','CT1','M10'),
					('V10',4,9000000.22,'D3','CT6','M1');
insert into ordered_customer(order_id,c_id) 
            values('O1','C1'),
			      ('O2','C10'),
				  ('O3','C7'),
				  ('O4','C2'),
				  ('O5','C3'),
				  ('O6','C6'),
				  ('O7','C9'),
				  ('O8','C4'),
				  ('O9','C9'),
				  ('O10','C8');
alter table ordered_customer add column order_date date;
insert into ordered_quantity(order_id,Order_Quantity,v_id)
            values('O1',3,'V2'),
			      ('O2',1,'V4'),
				  ('O3',2,'V3'),
				  ('O4',7,'V1'),
				  ('O5',6,'V6'),
				  ('O6',9,'V9'),
				  ('O7',10,'V4'),
				  ('O8',11,'V6'),
				  ('O9',14,'V5'),
				  ('O10',23,'V9');
select c_id,sum(order_quantity) from (ordered_customer natural join ordered_quantity )NATURAL join
                                      vehicle group by c_id   having sum(price)>10000000 order by c_id asc ;
select v_id,v_age from vehicle order by v_age;
select * from (vehicle join modify on vehicle.modify_id=modify.modify_id) natural full outer join dealer;
select v_id,v_age,price from vehicle where v_age<3 and price>1000000;
update  vehicle set v_age=v_age+1;
select * from vehicle;
select C_fname from customer where C_fname like '%ubb%';
select c_id,extract(year from order_date) as year,to_char(order_date,'mm') as month,to_char(order_date,'dd') as date from ordered_customer;
select v_id,v_age from vehicle where v_id in ('V1','V10') and price  between 1000000 and 50000000 ;
select v_id,v_age from vehicle where v_id not in ('V1','V10') and price  between 1000000 and 50000000 ;
select v_id,v_age from vehicle where v_id in ('V7','V6') and price  not between 10000 and 50000 ;
select v_id,v_age from vehicle where v_id not in ('V1','V5') and price  not between 10000 and 50000 ;
(select type_name,model_name,brand_name from Cartype where model_name='SPORT' ) union all (select type_name,model_name,brand_name from cartype where brand_name='AUDI');
(select type_name,model_name,brand_name from Cartype where model_name='SPORT' ) intersect all (select type_name,model_name,brand_name from cartype where brand_name='AUDI');
select v_id,v_age from vehicle natural join cartype where v_age<=5 and  v_id in
    ( select v_id from vehicle where price >
	 all(select price from vehicle natural join cartype where brand_name='AUDI' ));
select v_id,v_age from vehicle natural join cartype where v_age<=5 and  v_id in
    ( select v_id from vehicle where price >
	 any(select price from vehicle natural join cartype where brand_name='AUDI' ));
select brand_name,model_name,type_name from cartype where type_name in ('Q5','Q7','INDICA') and
exists (select brand_name,model_name,type_name from cartype natural join vehicle
		natural join modify where colour='BLACK');
select brand_name,model_name,type_name from cartype where type_name='Q5' and
not exists (select brand_name,model_name,type_name
															from cartype natural join modify 
												where colour='BLACK');
