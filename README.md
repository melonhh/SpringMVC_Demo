# SpringMVC_Demo
SpringMVC学习
## SpringMVC工作流程
![流程示意图](https://img-blog.csdn.net/20180803145042704?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQxOTEyMjA=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


## Controller
@Controller

### @RequestMapping()
> @RequestMapping作用  

* RequestDispatcherServlet负责将进入的http请求转交到控制器的处理方法
* @RequestMapping指定请求与处理方法之间的映射关系

> @RequestMapping参数详解

1. value、method
    * value(同path)：指请求的实际地址（三种模式）
        1. 普通值 ---- "/index"
        2. 含有变量 ---- "/index{id}"
            + 配合@PathVariable使用  
        3. 含正则表达式 ---- "/spring-{[a-z]+}"
       
    * method
        1. RequestMethod.POST
        2. RequestMethod.GET
        3. PUT、DELETE
        
2. consumes、produces
    * consumes：指定处理请求的提交内容类型（Content-Type）
    * produces：指定返回的内容类型（该类型在request请求头的Accept中被包含行）

3. params、headers
    * params：params={"username","age!=10"}
    * headers：request的请求头中必须含有指定的headers值才接收该请求
    
4. name（用来构建访问的url）
    * name默认值：类的所有大写字母 + # + 方法名
    * jsp页面中可以使用：
        ```
        <a href="${s:mvcUrl('IC#index').arg(0,'123').build()}">test name 参数</a>
        
5. 其他：
    * @RequestMapping可以用在类上 --- 相当于多了一层父目录
    * 支持三种通配符：
        1. ? --- 匹配一个字符
        2. * --- 匹配任意字符
        3. ** --- 匹配多层路径
        
### 参数注解
1. @RequestParam
    > 作用： 自动注入请求参数

    * @RequestParam(name="id", defaultValue="", require=false)
    * 参数名字要一致
    * 若前端没有输入值，那么会为int型的值赋为null，显然会报错，使用默认值来解决

2. @RequestHeader
    > 也是springMVC后台进行获取数据的注解

3. @CookieValue
    > 把请求头中关于cookie的值绑定到方法的参数上，同上面两个注解

4. 补充
    当表单元素的name值都使Java对象的属性时，controller中参数可以是POJO传值
    
### SpringMVC中模型数据的处理
也就是将controller中数据传递到jsp(四种途径输出模型数据)
1. ModelAndView
    * 处理方法返回值为ModelAndView
    * 方法体可通过该对象添加模型数据到请求域
    * model属性（ModelMap类型）
        * addObject()
    * view属性 --- 包含视图信息
        * setViewName()
    
2. Map、Model、ModelMap（参数）
    * Map
    * Model --- 写起来要比map要方便一点
    * ModelMap --- 采用两种写法，本质差不多
    * 处理方法返回时，map中的数据自动添加到模型中
    
3. @SessionAttribute(value={"xxx"}, types={xxx.class})
    * 是类注解，不能放在方法上
    * value --- 也就是将Request域中所有指定key的对象存入session域中
    * types --- 将Request域中所有某些类型的对象存入session域中
    * 这两个属性可以混合使用
    
4. @ModelAttribute
    * 使用方式：
        * 方法定义上 --- Spring MVC在调用目标处理方法前，会先逐个调用在方法级上标注了@ModelAttribute 的方法
        * 方法参数上 --- 
        
### 直接转发
可以不需要在Controller中做转发映射一些不需要其他操作的JSP页面
* <mvc:view-controller path="/index" view-name="index" />
    * 这个配置后可对/index直接转发
    * 但是正常需要通过Controller类的方法的url救会出现访问出错
    * 使用     <mvc:annotation-driven />   解决
* <mvc:view-controller path="/" view-name="redirect:/indexController"/> 
    * 重定向
    * 当前路径为/时，则重定向到indexController

> <mvc:annotation-driven />  
> 自动注册：  
   1. RequestMappingHandlerMapping
        * 实现这个类，它会处理@RequestMapping 注解，并将其注册到请求映射表中
   2. RequestMappingHandlerAdapter
        * 实现这个类，是处理请求的适配器，确定调用哪个类的哪个方法，并且构造方法参数，返回值。
        * 当配置了mvc:annotation-driven后，Spring就知道了我们启用注解驱动。
        * 然后Spring通过context:component-scan标签的配置，会自动为我们将扫描到的@Component，@Controller，@Service，@Repository等注解标记的组件注册到工厂中，来处理我们的请求。
   3. ExceptionHandlerExceptionResolver
   
还提供以下功能：  
    1. 支持使用 ConversionService 实例对表单参数进行类型转换；  
    2. 支持使用 @NumberFormat annotation、@DateTimeFormat注解完成数据类型的格式化；  
    3. 支持使用 @Valid 注解对 JavaBean 实例进行 JSR 303 验证；  
    4. 支持使用 @RequestBody 和 @ResponseBody 注解；  
    5. 读写XML的支持（JAXB），读写JSON的支持（Jackson），后面，我们处理响应ajax请求时，就使用到了对json的支持。  
    6. 当使用mvc:view-controller标签时一定要加入mvc:annotation-driven，不然会使requestMapping失效。  
    7. 后面，当为了处理静态资源问题而加入mvc:default-servlet-handler时，也一定要加入mvc:annotation-driven，不然requestMapping同样会失效。  
    8. 后面，当使用自定义类型转换器的时候需要加上mvc:annotation-driven标签。  
    9. 后面，对action写JUnit单元测试时，要从spring IOC容器中取DefaultAnnotationHandlerMapping与AnnotationMethodHandlerAdapter 两个bean，来完成测试，取的时候要知道是<mvc:annotation-driven />这一句注册的这两个bean进Spring的IOC容器的。