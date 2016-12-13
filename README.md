# Packease Framework for Java

We would like to build an approachable framework for learning and understanding the Java Web programming techniques. 
It is very funny and easy to read the sample codes in the project. 
We built it with the MVC design pattern, which is the most famous design pattern all around the world.

## Related components:

* Spring & Spring MVC
* MyBatis
* Slf4J Log Facade
* logback Log Framework
* ...

## Packages Overview

-- **src**   
--- **main**  
---- **java**  
-----  **(..., similar to group-id)**，"Package path"   
-------- **controller**，"Controllers"   
-------- **domain**，"Pojo Beans"   
----------- **po**，"Persistence Object"   
----------- **vo**，"Value Object"  
----------- **ro**，"Read Object"   
-------- **persistence**，"MyBatis Persistence Interfaces"   
-------- **service**，"Services Package"   
----------- **impl**，"Services Logic Detail"   

---- **resource**, "Resources package"   
-------- **config**, "Configuration Files for each of specific environments"   
-------- **mybatis**, "MyBatis SQL descriptions with xml format"   
-------- **spring**, "Configuration Files of Spring & Spring MVC frameworks"   

---- **webapp**, "Web Project Package"     
-------- **WEB-INF**,"WEB-INF directory design for Java Web Project"

## Quick Guide

1. You need to install a MySQL database, our project depends on it because of MyBatis usages.
2. To modify parameters of database resource, which wrote on the file `config/config-dev.properties`.
3. After finishing two steps above, you could now start up your server/container such as Jetty/Tomcat/JBoss.
4. Any of URLs below will show you some information that generated by project services.

    * http://localhost:8080/index?id=1
    * http://localhost:8080/json
    * http://localhost:8080/json4/{id}, you could replace `{id}` with any integer value.
    * http://localhost:8080/db, this could help you query the db data.
    
5. Here is the db table structures, this table is just design for developing, not for production environment.

```sql
CREATE TABLE `param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='demo';
```

## Development

P.E-framework-for-java has only one branch, and it is the only one used for active development.

- `master` for development.  **All pull requests should be submitted against `master`.**

Follow and contact me on [GitHub](https://github.com/jeromechan), [Sina Weibo](http://weibo.com/5812529126). 
If you find an issue, just open a ticket on it. Pull requests are warmly welcome as well.

## Author
- **Jerome Chan**
	- GitHub: <https://github.com/jeromechan>
	- Weibo: <http://weibo.com/5812529126>
	- Blog: <http://aboutcoder.com>

## License

Open sourced under the [MIT license](LICENSE.md).