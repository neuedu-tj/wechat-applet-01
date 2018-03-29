create table category (
  pid int NOT NULL AUTO_INCREMENT ,
  pname VARCHAR(100) NOT NULL ,
  level int(2) DEFAULT 0,
  create_time DATETIME ,
  last_modify_time DATETIME,
  PRIMARY KEY (pid),
  UNIQUE KEY (pname)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = UTF8