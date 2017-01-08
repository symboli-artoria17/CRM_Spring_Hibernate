# CRM_Spring_Hibernate
### This is a simple CRUD project implmented with Spring and Hibernate framework.

## Deployment:
	- Server: Tomcat 9.0 Library
	- Database: MySQL 5.7

## Dependencies:
	- Managed with Maven
	- Essentials:
		- Spring
		- Hibernate
		- C3p0 (Database connection pooling)
		- MySQL JDBC connector
		- JSTL


## Building Processes:
 	1. Create Database
	2. Define database dataSource/Connection pool
		In the spring bean configuration file, create a bean whose class is ComboPooledDataSource(From c3p0) for  connection pool and set the properties.
	3. Setup Hibernate session Factory (Spring ORM)
		same as above. Remember to ref the data source created in step 2.
	4. Setup Hibernate transaction manager
		same as above, ref SessionFactory
	5. Enable configuration of transactional annotations (for time saving, use the annotation)


## FAQ:
**	Q: Cannot resolve 'javax servlet'... blah blah blah?**
	
	A: Right click project -- Properties -- Deploy Assembly -- Make sure Maven is there. If not, add one.
	
		 