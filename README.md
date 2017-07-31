# Sentence checker

2 end-points: 
1 - to add words to the internal vocabulary
2 - to check sentence if it is valid or not.

## Getting Started

To start this application on your local machine you can:
  - run it from IDE (IntelliJIdea for example) as spring-boot project
  - build it as jar
   (using maven as it show below. It will also run tests)
   
   ```
   ./mvnw clean package
   ```
   and then run
   
   ```
   java -jar target/differentiator-0.0.1-SNAPSHOT.jar
   ```
   
## Using
   
   There are two end-points:
   1) to add words to the vocabulary
   
   ```
   <host>/v1/checker/sentence/add
   ```

    
   2) to check sentence
   
   ```
   <host>/v1/checker/sentence/check
   ```
   

    
   with the following json (for both end-points): 
   ```
   {
   
   	
   	"sentence": "Thsi is a valid sentence"
   	
   
   }
   ```
   
   
   
   ## Authors
   
   * **Vadzim Mikhalenak**
