# CRM_Spring_Hibernate
### This is a simple CRUD project implemented with Spring and Hibernate framework.
### Check out the Project Architecture in /ScreenShot/Architecture.PNG
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

## 3. Test Controller 
	1. Create a simple controller class. Remember, the scan package in beans.xml should be the right one. Also the view resolver.
	2. Make a landing page for the contorller
	3. Test the controller. (with Annotation: Controller, RequestMapping...)

## 4. List Customers Function

	1. Create Customer.java entity class (the class mapped to database table)
		- To configure the scanning package, set the property packagesToScan in SessionFactoryBean:
		  Open bean configuration file (here is beans.xml)
		  Configure the sessionFactory bean:
		  <property name="packagesToScan" value="crm.entity">
	2. Create CustomerDAO.java (interface) and CustomerDAOImpl.java for database access
		Define DAO Interface
		Define DAO Implementation
		@Transactional: Spring provides an @Transanctional annotation, automatically begin and end transaction
		Just put it before your method.
		No need extra code, like session.beginTransaction(), session.getTransaction().commit();
		
		Attention, when you are injecting a DAO using Autowired, remember, use the interface to create the instance. Say, use CustomerDAO to create customerDAO instead of using CustomerDAOImpl. (Spring will automatically scan for classes that implements the interface and inject it) 
		
		@Repository
		Specialized Annotation for DAO
		Spring will automatically register the DAO implementation
		Spring also provides translation of any JDBC related exceptions
		
	3. Create CustomerController.java
		update the controller 
		inject the DAO with @Autowired
		
	4. Create JSP page: list-customers.jsp
		import JSTL
		<% taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	5. Make it pretty with CSS
		Configure beans.xml: Add new lines in <beans>
		<mvc:resources location="/resources/" mapping="/resources/**"></mvc:resources>
		Attention! You must have that "/" after location="/resources"!
		location=physical directory name;
		/resources/** means url mapping ** to recurse subdirectories
		
		Add the line below under the <head> of list-customer.jsp
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></link>
	
	
## 5. Add the Welcome page
	1. Configure the web.xml to set a welcome page
		<welcome-file>/WEB-INF/view/Welcome.jsp</welcome-file>
		under the <welcome-file-list>
		
		The server will look for the files in <welcome-file-list> from top to down and use the first one it founds
		
## 6. Refactor: Change the annotation:
	
	GetMapping & PostMapping 
	
	change the RequestMapping in CustomerController to GetMapping

## 7. Refactor: Add a Service Facade
	
	Add a service layer between controller and DAO. Just because in some cases, you need to integrate multiple DAO and pass one integrated data to controller.
	See /ScreenShot/ServiceFacade.PNG for help.
	
	Here, we use @Service annotation to implement a service layer.
	
	- Define the service interface
	- Define Service implementation (Inject the CustomerDAO)
	- Move @Transactional to before Service Class
	
## 8. Add Customer Function
	
	Update list-customer.jsp
		- New "Add Customer" button: (onclick: Call the Spring controller mapping)
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'"></input>
		
	
	Create HTML form for new customer
	
	Process Form Data
		- Controller --> Service --> DAO

## 9. Update Customer

	1. Update list-customers.jsp
		New "Update" link:
		
		For each row, create a link that redirect to the update form page with the customer id as parameter:
		<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomer.id}"></c:param>
		</c:url>
		
		And display the link in the table:
		
		<td>
			<a href="${updateLink}">Update</a>
		</td>
		
	2. Create customer-form.jsp
		Pre-populate the form 
		
		The form will be pre-populated without using placeholder because Spring will automatically do that.
**		We used Spring form in that page, as a result, every time the form is loaded, spring mvc will call the getter method to display attributes. Also, every time submit the form, spring mvc call the setter method.
		
		Hidden form field is needed.
		Since update and add customer are using the same controller. You must make sure the update is not create a new record. 
		
		To solve this, there's a method in hibernate called saveOrUpdate. 
		We'll use it in the DAO impl.
		
		Beside, 
		specify the customer id that you want to update/add. It can be described in hidden field.
		This is very important because you want to make sure you are dealing with the record without confuse.
		
	3. Process form data
		Controller>Service>DAO

## 10. Delete Customer

	1. Add "Delete" link on JSP
		- Add Code for prompt user (with JavaScript)
	2. Add code for "Delete" 
		controller>service>DAO

## 11. Login Function

	1. A login page. 
	2. New controller, new service, new DAO
	3. For here, the default home page is Welcome.jsp. And if you want to go ahead, you need to click 'login' link. Because in this case, the controller can bring you to the login page with a model(session). Thus we can add attributes...and validate the username and password. I still didn't find out another way to do that. The Idea situation is login page as the welcome page. But we need to send a 
	

## FAQ:
**	Q: Cannot resolve 'javax servlet'... blah blah blah?**
	
	A: Right click project -- Properties -- Deploy Assembly -- Make sure Maven is there. If not, add one.
	
**  Q: Controller code doesn't work?

	A: Maybe a caching issue. Restart tomcat, clean the project, it might be fixed
	
**  Q: No found beans to inject?
	
	A: I guess you need to check the scan-package in beans.xml. Is the class you want Spring to inject included in the packages to scan? Remember the scanning is recursive(scan in the packages and the packages in the package).
	
	

# Some useful resources

**	Spring MVC and AngularJS CRUD

	- http://websystique.com/springmvc/spring-4-mvc-angularjs-crud-application-using-ngresource/

**	Spring MVC Validation

	- https://spring.io/guides/gs/validating-form-input/

**	Spring MVC and File Uploads

	- https://spring.io/guides/gs/uploading-files/

**	Spring RESTful web services

	- https://spring.io/guides/gs/rest-service/

**	Spring Security for Web Apps

	- https://spring.io/guides/gs/securing-web/

**	Spring and Facebook

	- https://spring.io/guides/gs/accessing-facebook/

**	Spring and Twitter

	- https://spring.io/guides/gs/accessing-twitter/