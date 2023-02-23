Steps to follow before running the program 
1. Update properties file with your mail sender properties 
2. If server failed to start copy paste Java-mail-sender dependencies.
3. If error in client side use "npm install" in the client side directory of the project.
4. In 
		public SwimmingPoolBasicSearchDTO findByTitle(String title)
	
	used a method :- IterableUtils.size(list)	
	Method is used to determine the size of Iterable objects , requires a dependency 
	The Apache Commons Collections library has a nice IterableUtils class that provides static utility methods for Iterable instances.
		
		<dependency>
			    <groupId>org.apache.commons</groupId>
			    <artifactId>commons-collections4</artifactId>
			    <version>4.1</version>
		</dependency>
		
	Already included in pom.xml

5. Comment if anything fails to work.