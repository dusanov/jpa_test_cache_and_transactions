# JPA test cache and transactions  
  
Testing if two persistent objects of the same record reflect the change with and without transaction  
  
To run it do: mvn spring-boot:run  
You will need a corresponding DB/Table

* Testing reference comparison  
* Testing object comparison  
* Testing field comparison  

###Conclusion:  
When transaction is turned on, both persistent entities point to the same object in memory so the change on one is reflected to the other while when there is no transaction wrapper, entities are pointing to two different objects in memory and the change on one entity is not reflected to the other.