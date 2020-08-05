# UserInfo
Here I use SpringBoot and REST API.
To Run- Import the project folder in SpringToolSuite4 and run as SpringBoot App 

Here using h2 mem DB and when run the application each time set of sample data will be inserted automatically.
Below are the descriptions of API call(using Postman / Advance Rest Caller).


1.To add User
url- http://localhost:8080/addUser
Method-POST
Request-(JSON)
{
 "uid": 3,
 "fristName": "soumen2",
 "lastName": "das2",
 "addresses": [
  {
   "aid": 1,
   "street": "Manikonda",
   "city": "Road",
   "state": "Hyd",
   "postalCode": 5
  }
  ]
 }


2.Edit user
Url - http://localhost:8080/editUser/1
Method - PUT
Request-(JSON)
{  
  "fristName": "soumen2",
  "lastName": "das"
}

3. List User

Url - http://localhost:8080/getAllUser
Method - GET
 
4. Count User
Url - http://localhost:8080/countUser
Method - GET

5. Edit Address

Url - http://localhost:8080/editAddress/2
Method - PUT
Request-(JSON)
{
  "street": "Manikonda1",
  "city": "Road2",
  "state": "Hyd2",
  "postalCode": 55
}

6.Delete User

Url - http://localhost:8080/deleteUser/1
Method - DELETE

7. Add Address

url- http://localhost:8080/addAddress
Method-POST
Request-(JSON)
{
    "aid": 1,
    "street": "Manikonda1",
    "city": "Road2",
    "state": "Hyd2",
    "postalCode": 55
}

8. Delete Address

Url - http://localhost:8080/deleteAddress/2
Method - DELETE



