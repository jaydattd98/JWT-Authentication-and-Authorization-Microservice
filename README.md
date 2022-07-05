# JWT-Authentication-and-Authorization-Microservice

Developed by: Dhorsinge Jaydatt

About Project :-

Using this Application its very easy to use. We can add new users easily and valided them on runtime.

1) Created Microservice for Authorization and Authentication purpose

2) Every request in any other Microservice will Authenticate by Jwt Authorization Microservice.

3) You just need to clone this repository

4) Use the follwing API to get simple JWT token in respose.

5) Once you get token, Store it in session either client side and backend side as you want.

6) Whenever you want to validate user just need to hit following API (with Token in header).(Get 401 not Authorized/200 ok for authorized)

7) Also Added Open API(Swagger)

8) This project comes with globle exception Handling(@RestControllerAdvice)

Swagger UI Access Point :

       http://localhost:8181/swagger-ui/index.html
       
       Using this url you will get all details Reagarding Request/Response and Schaemas used in project 

Database Access points :

       Jwt Application Tables : http://localhost:8080/h2-console/

Local accces point for Backend ;

       Authorization Microservice: http://localhost:8080/

Login Credentials:

       Dummy data already added

              Username : jaydatt 

              Password : jaydatt@123


Just for Refrence :-

APIS ;-

       Use to add new Users :-
              Method : POST

              URL: http://localhost:8989/auth/v1/create

              header :- token not need to send.

              Request : 
                     User {
                         "username": "jaydatt",
                         "password": "jaydatt@123",
                          "phoneNumber": "9158224033"
                       }

              Response :-
                       Status : 201 created
                       Body : User {
                         "username": "jaydatt",
                         "password": "jaydatt@123",
                          "phoneNumber": "9158224033"
                       }

       Use to login user :- 

             Method : POST

             ULR: http://localhost:8080/auth/v1/login

             header :- token not need to send.

             Request : 
                     JWTRequest {
                         "username": "jaydatt",
                         "password": "jaydatt@123"
                       }

             Response: 
                       Status : 200 OK
                       Body : JWTResponse :{"token":       "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXlkYXR0IiwiaWF0IjoxNjU2ODM1MjUyLCJleHAiOjE2NTY4MzcwNTJ9.uwHasXhQhfzSnQtd6ZlCS2Lx0PXteKS8q3z_AcIWIdgdUhp0j0pS29a1RuzloLcfnELMmmOk5Gyw1f5uEY0GlA"}

       Use to validate user :-

             Method : GET

             ULR: http://localhost:8080/auth/v1/isTokenValid

             Request : not needed

             header: token need to send 
                     {Authorization : Bearer Bearer eyJhbGciOiJIUzUxMiJ9..Z177q3fbySjf2Za0AutBJgUkH-HJmp2Mrpi4GiMbfNDHrcsHcvo_eqge3Ba9D0oniAJzB0ZSIPtH7oIdGYlPuA}

             Response: 
                   Status : 200 OK
                   Body : TRUE

                   If no token sent or No token is expire or either not valide user
             Response:
                   status : 401 UnAuthorized
        
                

