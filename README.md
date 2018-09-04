# mySpringCloud
springCloud组件学习
主要组件包括： Eureka注册中心，Ribbon+restTemplate负载均衡，feign负载均衡
在feign中，pom.xml由于版本问题只能通过以下springboot和springcloud组合，否则出现jar包冲突情况。
 Spring Cloud	                   Spring Boot
  Finchley	         兼容Spring Boot 2.0.x，不兼容Spring Boot 1.5.x
  Dalston和Edgware	  兼容Spring Boot 1.5.x，不兼容Spring Boot 2.0.x
  Camden	           兼容Spring Boot 1.4.x，也兼容Spring Boot 1.5.x
  Brixton	           兼容Spring Boot 1.3.x，也兼容Spring Boot 1.4.x
  Angel	             兼容Spring Boot 1.2.x
