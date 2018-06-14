2018-6-13  Day13


## 实现一个简单的MVC框架
#### 设计思想
- 因为MVC中的C，即Controller（控制器）主要负责两件事，一是依据请求路径调用合适的模块来处理请求，另外，依据模型返回的处理结果调用合适的视图来展现处理结果。所以，我们可以实现一个通用的控制器，该控制器可以通过读取配置文件或者java注解中的配置信息，来调用对应的模型或者视图。

#### MVC架构的搭建（详见Demo ：smartMVC）
- MVC框架开发思路：



#### 使用smartMVC
- step1 : 导入dom4j的jar包
- step2 : 将smartMVC的核心包copy到smartMVC-Demo里面
- step3 : 配置DispatcherServlet(在web.xml里面配置)。
- step4 : 添加smartmvc.xml
- step5 : 添加处理器（比如LoginController）,在该处理器里面，方法前添加
@RequestMapping注解，方法的返回值是视图名。
- step6 : 添加jsp,注意jsp文件名应该符合 "/WEB-INF/" + 视图名 + ".jsp" 。
- step7 : 在smartmvc.xml文件里配置完整class位置(处理器的配置)

































