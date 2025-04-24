create database store_prj
use store_prj

create table users (
	id int Identity(1,1) Primary key,
	email nvarchar(100) unique not null,
	password nvarchar(255) not null,
	firstName nvarchar(25)not null,
	lastName nvarchar(25) not null,
	gender int not null,
	address nvarchar(100),
	role int
)

create table products(
	id int identity(1,1) primary key,
	title nvarchar(100) not null,
	description nvarchar(max),
	brand nvarchar(30),
	color nvarchar(20),
	size nvarchar(15),
	type nvarchar(20),
	price float,
	releaseDate int,
	imageURL nvarchar(max)
)

create table carts(
	userId int,
	productId int,
	primary key(userId,productId),
	foreign key (userId) references users(id),
	foreign key (productId) references products(id)
)
--admin co role = 1 , user co role = 0
INSERT INTO users (email, password, firstName, lastName, gender, address, role) 
VALUES 
('user1@example.com', '1', 'John', 'Doe', 0, '123 Street, City', 0),
('user2@example.com', '1', 'Jane', 'Smith', 1, '456 Avenue, City', 0),
('user3@example.com', '1', 'Alex', 'Brown', 2, '789 Road, City', 0),
('user4@example.com', '1', 'Emily', 'Davis', 1, '159 Lane, City', 0),
('user5@example.com', '1', 'Michael', 'Wilson', 0, '753 Boulevard, City', 0),
('user6@example.com', '1', 'David', 'Taylor', 0, '852 Street, City', 0),
('user7@example.com', '1', 'Sarah', 'Miller', 1, '951 Avenue, City', 0),
('user8@example.com', '1', 'Chris', 'Anderson', 0, '357 Road, City', 0),
('user9@example.com', '1', 'Laura', 'Thomas', 1, '246 Lane, City', 0),
('user10@example.com', '1', 'Daniel', 'Jackson', 0, '135 Boulevard, City', 0),
('user11@example.com', '1', 'Jessica', 'White', 1, '864 Street, City', 0),
('user12@example.com', '1', 'Brian', 'Harris', 0, '753 Avenue, City', 0),
('user13@example.com', '1', 'Samantha', 'Martin', 1, '369 Road, City', 0),
('user14@example.com', '1', 'Kevin', 'Thompson', 0, '258 Lane, City', 0),
('user15@example.com', '1', 'Amanda', 'Garcia', 1, '147 Boulevard, City', 0),
('user16@example.com', '1', 'Eric', 'Martinez', 0, '753 Street, City', 0),
('user17@example.com', '1', 'Rachel', 'Robinson', 1, '159 Avenue, City', 0),
('user18@example.com', '1', 'James', 'Clark', 0, '357 Road, City', 0),
('user19@example.com', '1', 'Sophia', 'Rodriguez', 1, '246 Lane, City', 0),
('user20@example.com', '1', 'Ethan', 'Lewis', 0, '135 Boulevard, City', 0),
('user21@example.com', '1', 'Megan', 'Lee', 1, '864 Street, City', 0),
('user22@example.com', '1', 'Matthew', 'Walker', 0, '753 Avenue, City', 0),
('user23@example.com', '1', 'Olivia', 'Hall', 1, '369 Road, City', 0),
('user24@example.com', '1', 'Andrew', 'Allen', 0, '258 Lane, City', 0),
('user25@example.com', '1', 'Emily', 'Young', 1, '147 Boulevard, City', 0),
('admin@gmail.com', '1', 'admin', 'host', 0, '123 Street, City', 1);

--title dat ten = brand + color + loai product
INSERT INTO products (title, description, brand, color, size, type, price, releaseDate, imageURL)  
VALUES  
(N'Nike Black Baseball Cap', N'Mũ lưỡi trai phong cách thể thao.', N'Nike', N'Black', N'Free Size', N'Cap', 250000, 2023, N'baseball_cap_nike_black.jpg'),  
(N'Adidas Blue Snapback Hat', N'Mũ snapback thời trang.', N'Adidas', N'Blue', N'Free Size', N'Snapback', 300000, 2022, N'snapback_cap_addidas_white.jpg'),  
(N'Puma Beige Bucket Hat', N'Mũ bucket phong cách streetwear.', N'Puma', N'Beige', N'Medium', N'Bucket', 280000, 2024, N'buck_hat_puma_beige.jpg'),  
(N'Vans Red Trucker Hat', N'Mũ trucker thoáng khí.', N'Vans', N'Red', N'Large', N'Trucker', 270000, 2021, N'trucker_hat_vans_red.jpg');
INSERT INTO products ( title, description, brand, color, size, type, price, releaseDate, imageURL)
VALUES  
(N'Baseball Cap', N'MLB Varsity Lettering Color Block. ', N'MLB Korea', N'Cam', N'Large', N'Cap', 113000, 2019, N'baseball_hat_lethnic_beige.jpg');

INSERT INTO products (title, description, brand, color, size, type, price, releaseDate, imageURL)
VALUES  
(N'Baseball Cap', N'Mũ Baseball thoáng khí.', N'LETHNIC', N'Cam', N'Large', N'Ball Cap', 189000, 2020, N'baseball_hat_lethnic_cam.jpg');
INSERT INTO products (title, description, brand, color, size, type, price, releaseDate, imageURL)
VALUES  
(N'MLB Varsity', N'MLB Varsity Lettering Color Block. ', N'MLB Korea', N'Cam', N'Free Size', N'Cap', 113000, 2020, N'MLB_hat_MLB_cam.jpg');
SELECT * FROM products;
drop table products;











