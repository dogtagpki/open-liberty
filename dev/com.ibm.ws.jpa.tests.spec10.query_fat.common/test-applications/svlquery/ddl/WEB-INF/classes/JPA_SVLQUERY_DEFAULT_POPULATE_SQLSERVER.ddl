INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('1780 Mercury Way','Morgan Hill','CA','95037');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('150 North First Apt E1','San Jose','CA','94003');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('12440 Vulcan Avenue','Los Altos','CA','95130');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('182 Martian Street','San Jose','CA','95120');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('8900 Jupiter Park','San Jose','CA','94005');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('4983 Plutonium Avenue','Palo Alto','CA','95140');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('512 Venus Drive','Morgan Hill','CA','95037');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('6200 Vegas Drive','San Jose','CA','95120');
INSERT INTO JPAADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('555 Silicon Valley Drive','San Jose','CA','94120');
INSERT INTO JPACUSTOMERPARTTAB (ID,NAME,RATING) VALUES (2,'cust2',2);
INSERT INTO JPACUSTOMERPARTTAB (ID,NAME,RATING) VALUES (1,'cust1',1);
INSERT INTO JPADEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (100,2.0999999,'CEO',NULL,NULL,10,100);
INSERT INTO JPADEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (200,2.0999999,'Admin',NULL,NULL,8,100);
INSERT INTO JPADEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (210,2.0999999,'Development',1000,'WorldWildlifeFund',3,200);
INSERT INTO JPADEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (220,2.0999999,'Service',2000,'GlobalWarmingFund',4,200);
INSERT INTO JPADEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (300,2.0999999,'Sales',NULL,NULL,6,100);
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (10,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'Catalina Wei',5,0,NULL,NULL,'555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (8,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'Tom Rayburn',4,0,100,'6200 Vegas Drive','555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (3,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'minmei',2,15.5,200,'1780 Mercury Way','555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (9,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'harry',5,0,210,'150 North First Apt E1','8900 Jupiter Park');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (6,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'ahmad',3,0,100,'4983 Plutonium Avenue','4983 Plutonium Avenue');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (2,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',0,'andrew',1,13.1,210,'1780 Mercury Way','555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (7,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'charlene',4,0,210,'182 Martian Street','555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (4,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'george',2,0,200,'512 Venus Drive','555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (5,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'ritika',3,0,220,'12440 Vulcan Avenue','555 Silicon Valley Drive');
INSERT INTO JPAEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (1,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',0,'david',1,12.1,210,'1780 Mercury Way','555 Silicon Valley Drive');
INSERT INTO JPALINEITEMPARTTAB (LID,COST,QUANTITY,ORDER_OID,PRODUCT_PID) VALUES (1,100.5,5,1,1);
INSERT INTO JPALINEITEMPARTTAB (LID,COST,QUANTITY,ORDER_OID,PRODUCT_PID) VALUES (2,100.5,5,2,1);
INSERT INTO JPAORDERPARTTAB (OID,AMOUNT,DELIVERED,CUSTOMER_ID) VALUES (1,502.5,0,1);
INSERT INTO JPAORDERPARTTAB (OID,AMOUNT,DELIVERED,CUSTOMER_ID) VALUES (2,502.5,0,2);
INSERT INTO JPAPARTTAB (PARTNO,NAME,PARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (11,'P11','PartBase',NULL,NULL,110,25.8);
INSERT INTO JPAPARTTAB (PARTNO,NAME,PARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (10,'P10','PartBase',NULL,NULL,10,15.25);
INSERT INTO JPAPARTTAB (PARTNO,NAME,PARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (12,'P12','PartBase',NULL,NULL,114,82.01);
INSERT INTO JPAPARTTAB (PARTNO,NAME,PARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (21,'C21','PartComposite',0,15,NULL,NULL);
INSERT INTO JPAPARTTAB (PARTNO,NAME,PARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (99,'C99','PartComposite',10,20,NULL,NULL);
INSERT INTO JPAPARTTAB (PARTNO,NAME,PARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (20,'C20','PartComposite',7.5,1,NULL,NULL);
INSERT INTO JPAPRODUCTPARTTAB (PID,BACKORDER,DESCRIPTION,INVENTORY,SUPPLIER_ID) VALUES (1,20,'baffles',10,NULL);
INSERT INTO JPAPROJECTBEAN (PROJID,BUDGET,COST,DESCRIPTION,DURATIONDAYS,NAME,PERSONMONTHS,STARTTIME,DEPT_DEPTNO) VALUES (1000,NULL,123.45,'WebSphere Version 1',20,'Project:1000',10,50,210);
INSERT INTO JPAPROJECTBEAN (PROJID,BUDGET,COST,DESCRIPTION,DURATIONDAYS,NAME,PERSONMONTHS,STARTTIME,DEPT_DEPTNO) VALUES (3000,NULL,123.45,'WebSphere Community Edition',10,'Project:3000',45,100,NULL);
INSERT INTO JPAPROJECTBEAN (PROJID,BUDGET,COST,DESCRIPTION,DURATIONDAYS,NAME,PERSONMONTHS,STARTTIME,DEPT_DEPTNO) VALUES (2000,NULL,123.45,'WebSphere Feature Pack',10,'Project:2000',40,100,220);
INSERT INTO JPASUPPLIERPARTTAB (SID,NAME) VALUES (2,'S2');
INSERT INTO JPASUPPLIERPARTTAB (SID,NAME) VALUES (1,'S1');
INSERT INTO JPASUPPLIERPARTTAB_JPAPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (2,10);
INSERT INTO JPASUPPLIERPARTTAB_JPAPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (2,12);
INSERT INTO JPASUPPLIERPARTTAB_JPAPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (1,10);
INSERT INTO JPASUPPLIERPARTTAB_JPAPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (1,11);
INSERT INTO JPASUPPLIERPARTTAB_JPAPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (1,12);
INSERT INTO JPATASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (1010,123.45,'Design','Design',1000);
INSERT INTO JPATASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (2010,123.45,'Design','Design',2000);
INSERT INTO JPATASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (1020,123.45,'Code','Code',1000);
INSERT INTO JPATASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (2020,123.45,'Code, Test','Code, Test',2000);
INSERT INTO JPATASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (1030,123.45,'Test','Test',1000);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1010,1);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (2010,1);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1020,1);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1020,2);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1020,9);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1030,9);
INSERT INTO JPATASKBEAN_JPAEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1030,5);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (990010,4,10,99);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (990020,1,20,99);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (210011,1,11,21);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (990021,1,21,99);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (210012,1,12,21);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (200010,4,10,20);
INSERT INTO JPAUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (210010,4,10,21);
INSERT INTO JPAXYZ (ID,AGE,FIRSTNAME,LASTNAME) VALUES (0,0,'OpenJPA',NULL);

INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('1780 Mercury Way','Morgan Hill','CA','95037');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('150 North First Apt E1','San Jose','CA','94003');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('12440 Vulcan Avenue','Los Altos','CA','95130');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('182 Martian Street','San Jose','CA','95120');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('8900 Jupiter Park','San Jose','CA','94005');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('4983 Plutonium Avenue','Palo Alto','CA','95140');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('512 Venus Drive','Morgan Hill','CA','95037');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('6200 Vegas Drive','San Jose','CA','95120');
INSERT INTO JPAXMLADDRESSBEAN (STREET,CITY,STATE,ZIP) VALUES ('555 Silicon Valley Drive','San Jose','CA','94120');
INSERT INTO JPAXMLCUSTOMERPARTTAB (ID,NAME,RATING) VALUES (2,'cust2',2);
INSERT INTO JPAXMLCUSTOMERPARTTAB (ID,NAME,RATING) VALUES (1,'cust1',1);
INSERT INTO JPAXMLDEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (100,2.0999999,'CEO',NULL,NULL,10,100);
INSERT INTO JPAXMLDEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (200,2.0999999,'Admin',NULL,NULL,8,100);
INSERT INTO JPAXMLDEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (210,2.0999999,'Development',1000,'WorldWildlifeFund',3,200);
INSERT INTO JPAXMLDEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (220,2.0999999,'Service',2000,'GlobalWarmingFund',4,200);
INSERT INTO JPAXMLDEPTBEAN (DEPTNO,BUDGET,NAME,CHARITYAMOUNT,CHARITYNAME,MGR_EMPID,REPORTSTO_DEPTNO) VALUES (300,2.0999999,'Sales',NULL,NULL,6,100);
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (10,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'Catalina Wei',5,0,NULL,NULL,'555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (8,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'Tom Rayburn',4,0,100,'6200 Vegas Drive','555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (3,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'minmei',2,15.5,200,'1780 Mercury Way','555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (9,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'harry',5,0,210,'150 North First Apt E1','8900 Jupiter Park');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (6,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'ahmad',3,0,100,'4983 Plutonium Avenue','4983 Plutonium Avenue');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (2,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',0,'andrew',1,13.1,210,'1780 Mercury Way','555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (7,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'charlene',4,0,210,'182 Martian Street','555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (4,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'george',2,0,200,'512 Venus Drive','555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (5,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',1,'ritika',3,0,220,'12440 Vulcan Avenue','555 Silicon Valley Drive');
INSERT INTO JPAXMLEMPBEAN (EMPID,BONUS,EXECLEVEL,HIREDATE,HIRETIME,HIRETIMESTAMP,ISMANAGER,NAME,RATING,SALARY,DEPT_DEPTNO,HOME_STREET,WORK_STREET) VALUES (1,0,'A','1969-12-31','16:00:00','1969-12-31 16:00:00.000',0,'david',1,12.1,210,'1780 Mercury Way','555 Silicon Valley Drive');
INSERT INTO JPAXMLLINEITEMPARTTAB (LID,COST,QUANTITY,ORDER_OID,PRODUCT_PID) VALUES (1,100.5,5,1,1);
INSERT INTO JPAXMLLINEITEMPARTTAB (LID,COST,QUANTITY,ORDER_OID,PRODUCT_PID) VALUES (2,100.5,5,2,1);
INSERT INTO JPAXMLORDERPARTTAB (OID,AMOUNT,DELIVERED,CUSTOMER_ID) VALUES (1,502.5,0,1);
INSERT INTO JPAXMLORDERPARTTAB (OID,AMOUNT,DELIVERED,CUSTOMER_ID) VALUES (2,502.5,0,2);
INSERT INTO JPAXMLPARTTAB (PARTNO,NAME,XMLPARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (11,'P11','PartBase',NULL,NULL,110,25.8);
INSERT INTO JPAXMLPARTTAB (PARTNO,NAME,XMLPARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (10,'P10','PartBase',NULL,NULL,10,15.25);
INSERT INTO JPAXMLPARTTAB (PARTNO,NAME,XMLPARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (12,'P12','PartBase',NULL,NULL,114,82.01);
INSERT INTO JPAXMLPARTTAB (PARTNO,NAME,XMLPARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (21,'C21','PartComposite',0,15,NULL,NULL);
INSERT INTO JPAXMLPARTTAB (PARTNO,NAME,XMLPARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (99,'C99','PartComposite',10,20,NULL,NULL);
INSERT INTO JPAXMLPARTTAB (PARTNO,NAME,XMLPARTTYPE,ASSEMBLYCOST,MASSINCREMENT,COST,MASS) VALUES (20,'C20','PartComposite',7.5,1,NULL,NULL);
INSERT INTO JPAXMLPRODUCTPARTTAB (PID,BACKORDER,DESCRIPTION,INVENTORY,SUPPLIER_ID) VALUES (1,20,'baffles',10,NULL);
INSERT INTO JPAXMLPROJECTBEAN (PROJID,BUDGET,COST,DESCRIPTION,DURATIONDAYS,NAME,PERSONMONTHS,STARTTIME,DEPT_DEPTNO) VALUES (1000,NULL,123.45,'WebSphere Version 1',20,'Project:1000',10,50,210);
INSERT INTO JPAXMLPROJECTBEAN (PROJID,BUDGET,COST,DESCRIPTION,DURATIONDAYS,NAME,PERSONMONTHS,STARTTIME,DEPT_DEPTNO) VALUES (3000,NULL,123.45,'WebSphere Community Edition',10,'Project:3000',45,100,NULL);
INSERT INTO JPAXMLPROJECTBEAN (PROJID,BUDGET,COST,DESCRIPTION,DURATIONDAYS,NAME,PERSONMONTHS,STARTTIME,DEPT_DEPTNO) VALUES (2000,NULL,123.45,'WebSphere Feature Pack',10,'Project:2000',40,100,220);
INSERT INTO JPAXMLSUPPLIERPARTTAB (SID,NAME) VALUES (2,'S2');
INSERT INTO JPAXMLSUPPLIERPARTTAB (SID,NAME) VALUES (1,'S1');
INSERT INTO JPAXMLSUPPLIERPARTTAB_JPAXMLPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (2,10);
INSERT INTO JPAXMLSUPPLIERPARTTAB_JPAXMLPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (2,12);
INSERT INTO JPAXMLSUPPLIERPARTTAB_JPAXMLPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (1,10);
INSERT INTO JPAXMLSUPPLIERPARTTAB_JPAXMLPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (1,11);
INSERT INTO JPAXMLSUPPLIERPARTTAB_JPAXMLPARTTAB (SUPPLIERS_SID,SUPPLIES_PARTNO) VALUES (1,12);
INSERT INTO JPAXMLTASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (1010,123.45,'Design','Design',1000);
INSERT INTO JPAXMLTASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (2010,123.45,'Design','Design',2000);
INSERT INTO JPAXMLTASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (1020,123.45,'Code','Code',1000);
INSERT INTO JPAXMLTASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (2020,123.45,'Code, Test','Code, Test',2000);
INSERT INTO JPAXMLTASKBEAN (TASKID,COST,DESCRIPTION,NAME,PROJECT_PROJID) VALUES (1030,123.45,'Test','Test',1000);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1010,1);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (2010,1);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1020,1);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1020,2);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1020,9);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1030,9);
INSERT INTO JPAXMLTASKBEAN_JPAXMLEMPBEAN (TASKS_TASKID,EMPS_EMPID) VALUES (1030,5);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (990010,4,10,99);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (990020,1,20,99);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (210011,1,11,21);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (990021,1,21,99);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (210012,1,12,21);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (200010,4,10,20);
INSERT INTO JPAXMLUSAGEPARTTAB (ID,QUANTITY,CHILD_PARTNO,PARENT_PARTNO) VALUES (210010,4,10,21);
INSERT INTO JPAXMLXYZ (ID,AGE,FIRSTNAME,LASTNAME) VALUES (0,0,'OpenJPA',NULL);
