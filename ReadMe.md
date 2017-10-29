Conditions:
---
Create a Java REST based web application leveraging Spring Boot. 

1. The application must expose CRUD (Create, Read, Update, Delete) operations mapped onto HTTP methods. 
2. The application to create is a single author blog, it should have CRUD operations on Posts. 
A single Post comprises Title, Content, Tags. 
3. Basic-Authentication must be in place for one user. 
4. Unit-tests should cover application’content crucial parts. 
5. As a database an “in memory db” should be used e.g. h2.
6. No front end is needed, however, the endpoints must be listed in application documentation 
alongside with the way how to run and work with the application.
7. Source code should be available on a public git repository.

Description of solution:
---
Java REST based web application leveraging Spring Boot was created.
Basic-Authentication is done (Username: nicolas ; password: password). 
“In memory db” configured. JUnit tests present, they cover main crud operations with db. 
In order to test rest controller, mocks were used. 

Request mapping:

method|uri|action
------|------------------------|------
GET | /posts | get all posts
GET | /posts/{id} | get certain post
POST | /posts | create post
PUT | /posts/{id} | update certain post
DELETE | /posts/{id} | delete certain post
GET | /posts/{id}/tags | get tags from certain post
GET | /posts/{id}/tags/{tagId} | get tag by Id from certain post
POST | /posts/{id}/tags | create tag in certain post
DELETE | /posts/{id}/tags/{tagId} | delete tag by id from certain post
GET | /posts/tags | get all tags
GET | posts/tags/{id} | get certain tag
PUT | /posts/tags/{id} | update certain tag

Postman hints:
---
Example of dummy blog object with two tags.
```json
{  
   "id":2,
   "title":"Java Core",
   "content":"2 Steps",
   "tags":[  
      {  
         "id":4,
         "content":"basic core"
      },
      {  
         "id":5,
         "content":"advanced topics"
      }
   ]
}
```

