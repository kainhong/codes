public class TestRegisterBean {

 public static void main(String[] args) {

  ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
    "applicationContext.xml");//在web环境下也可通过如下如方式获取
//WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent
      .getServletContext());
  
  DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)                 

applicationContext.getBeanFactory();
  GenericBeanDefinition messageSourceDefinition = new GenericBeanDefinition();
 
  //参数参考上面配置文件里面
  Map<String , String> original = new HashMap<String, String>();
  original.put("basenames", "messages");
  original.put("useCodeAsDefaultMessage", "true");
  messageSourceDefinition.setBeanClass(ResourceBundleMessageSource.class);
  messageSourceDefinition.setPropertyValues(new MutablePropertyValues(original));
  //注册
  beanFactory.registerBeanDefinition("ResourceBundleMessageSource",
    messageSourceDefinition);
  //获取
  ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) applicationContext
    .getBean("ResourceBundleMessageSource");
                //测试
  System.out.println(messageSource.getMessage("test", null, null));
 }

}