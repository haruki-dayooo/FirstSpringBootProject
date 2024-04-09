-- Database: UserManagement

-- DROP DATABASE IF EXISTS "UserManagement";

CREATE DATABASE "UserManagement"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
CREATE TABLE tblusers(
	userID varchar(50) NOT NULL,
	fullName varchar(50) NULL,
	password varchar(50) NULL,
	roleID varchar(50) NULL,
	status boolean NULL,
	CONSTRAINT PK_tblUsers PRIMARY KEY (userID)
);

INSERT INTO tblusers (userid, fullname, password, roleid, status) 
VALUES
    ('admin', 'Tao la admin', '1', 'AD', TRUE),
    ('hoadoan', 'Hòa Đoàn', '1', 'AD', TRUE),
	('SE183775', 'Lê Vũ Đức Lương', '1', 'AD', TRUE),
	('SE123456', 'tui la user', '1', 'AD', TRUE);
	
SELECT * FROM tblusers	