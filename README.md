# Welcome to myRetail Case Study!
This project exposes various APIs which can be used to interact with Product details database. The
APIs are as below
                    
Method           |API                           |Result                       
|----------------|-------------------------------|-----------------------------
|GET             | /products                     | Fetches all the products in db          
|GET| /products/id            |Fetches single product with id number. The ID should be a number       
| POST          | /products|Creates a new product in DB
| PUT          | /products|Updates product in DB, exception if product not found
| DELETE          | /products/id|Deletes product in DB with ID number


# Case Study Requirements

1. The Product and Product description source is different, but the API response should contain the combined data (Product Details + Description).
2. CRUD Operations.
3. The APIs should be secured (use **user/password** as **admin/nimda** in creating Basic Auth header in Postman)

## Running the Application

**Windows :**
	Run following command from location where POM.xml is present 
	**mvnw.cmd spring-boot:run**

**Mac/Linux**
	Run following command from location where POM.xml is present 
	**mvnw spring-boot:run**

## Mongo DB
The MongoDB used is cloud hosted MongoDB by Mlab. [https://mlab.com](https://mlab.com/)
