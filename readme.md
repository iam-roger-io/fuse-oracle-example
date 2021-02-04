## Setup Oracle

  Create  a table named **person**
 
    CREATE TABLE PERSON
    (
      ID NUMBER(*, 0) NOT NULL 
    , NAME VARCHAR2(50 BYTE) NOT NULL 
    , CONSTRAINT PERSON_PK PRIMARY KEY 
      (
        ID 
      )
    ) 


>  NOTE: In the tests, the schema called sys was used.

 
Allows you to ignore the default name for the username defined in Oracle.

    alter session set "_ORACLE_SCRIPT"=true;
  
Create a user to connect through JDBC. My suggestion is **camel**	

    create user camel identified by "1qaz@WSX"
  
Allow the user to log in.
 

    GRANT create session TO camel; 

Allow the user to execute basic operations
 
    GRANT
      SELECT,
      INSERT,
      UPDATE,
      DELETE
    ON
      sys.person
    TO
      camel;

  
## TO Run

	mvn clean spring-boot:run