CREATE TABLE Member
(
	MemNo INT,
	DriverLic VARCHAR(40),
	Fname VARCHAR(20),
	MI CHAR(2),
	Lname VARCHAR(20),
	Address VARCHAR(250),
	PhoneNumber VARCHAR(15),

	PRIMARY KEY (MemNo)
);
CREATE TABLE Title
(
	CallNumber VARCHAR(40),
	Name VARCHAR(200),
	ISBN VARCHAR(40),
	Year INT,
	Publisher VARCHAR(80),

	PRIMARY KEY (CallNumber),
	UNIQUE (ISBN)
);
CREATE TABLE Book
(
	Book_ID INT,
	Edition VARCHAR(80),
	BorrowerMemNo INT,
	BorrowDueDate DATE,
	CallNumber VARCHAR(40),

	PRIMARY KEY (Book_ID),
	FOREIGN KEY (CallNumber) REFERENCES Title(CallNumber), FOREIGN KEY (BorrowerMemNo) REFERENCES Member(MemNo)
);

INSERT INTO Title VALUES ('Call123', 'Iliad', 'ISBN123', 1997,'Homer Publishing');
INSERT INTO Title VALUES ('Call124', 'Odyssey', 'ISBN124', 1997, 'Homer Publishing');
INSERT INTO Title VALUES ('Call125', 'Database Systems', 'ISBN125', 1999, 'AWL');
INSERT INTO Title VALUES ('Call126', '100% Financial Accounting', 'ISBN126', 1997, 'McGrawHill');
INSERT INTO Member VALUES (123, 'PA 123', 'John', '', 'Summers', '4615 Forbes Ave, Pittsburgh, PA 15213', '412-268-0001');
INSERT INTO Member VALUES (124, 'GA 124', 'Jon', '', 'Butterworth', '10 Fifth Ave, Atlanta, GA 30332', '404-894-0001');
INSERT INTO Member VALUES (125, 'PA 125', 'Susan', 'B', 'Carlione', '4600 Verona Road, Pittsburgh, PA 15217', '412-200-0001');
INSERT INTO Member VALUES (126, 'NC 126', 'Mohammed', '', 'Ismail', '250 Peachtree Street, Salem, NC 15213', '421-268-0001');
INSERT INTO Member VALUES (127, 'PA 127', 'Asterio', '', 'Tanaka', '415 Craig Street, Pittsburgh, PA 15213', '412-220-0001');
INSERT INTO Book VALUES (123, '1', 123, '2012-01-12', 'Call123');
INSERT INTO Book VALUES (223, '1', 125, '2012-09-11', 'Call123');
INSERT INTO Book VALUES (124, '1', 124, '2012-06-09', 'Call124');
INSERT INTO Book VALUES (224, '1', 125, '2012-11-11', 'Call124');
INSERT INTO Book VALUES (125, '1', 125, '2012-11-11', 'Call125');
INSERT INTO Book VALUES (225, '1', NULL, NULL, 'Call125');
INSERT INTO Book VALUES (126, '1', 125, '2012-11-11', 'Call126');
INSERT INTO Book VALUES (226, '1', NULL, NULL, 'Call126');
