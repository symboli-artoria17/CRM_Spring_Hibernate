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


## 1. Building Preparation:
 	1. Build the database (the script is provided in SQLResource folder)
 	2. Make the project Dynamic Web + convert to Maven project. Get those dependencies.
 	3. Create web.xml (Right click project -- JavaEE tool -- Generate Project Descriptor Stub)
 	4. Initialize the dispatch servlet in web.xml. 
 	5. Configure the dispatcher, with the name of Spring Bean Configuration file. Specify the location. (Here I put it in /WEB-INF/beans.xml)
 	
## 2. Now, Configure the Spring Bean Configuration file
	1. Define database dataSource/Connection pool
		In the spring bean configuration file, create a bean whose class is ComboPooledDataSource(From c3p0) for  connection pool and set the properties.
	2. Setup Hibernate session Factory (Spring ORM)
		same as above. Remember to ref the data source created in step 2.
	3. Setup Hibernate transaction manager
		same as above, ref SessionFactory
	4. Enable configuration of transactional annotations (for time saving, use the annotation)

### 3. Test Controller 
	1. Create a simple controller class. Remember, the scan package in beans.xml should be the right one. Also the view resolver.
	2. Make a landing page for the contorller
	3  . Test the controller. (with Annotation: Controller, RequestMapping...)

## FAQ:
**	Q: Cannot resolve 'javax servlet'... blah blah blah?**
	
	A: Right click project -- Properties -- Deploy Assembly -- Make sure Maven is there. If not, add one.
	
**  Q: Controller code doesn't work?

	A: Maybe a caching issue. Restart tomcat, clean the project, it might be fixed