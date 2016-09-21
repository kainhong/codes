public class TestRegisterBean {

 public static void main(String[] args) {

  ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
    "applicationContext.xml");//��web������Ҳ��ͨ�������緽ʽ��ȡ
//WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent
      .getServletContext());
  
  DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)                 

applicationContext.getBeanFactory();
  GenericBeanDefinition messageSourceDefinition = new GenericBeanDefinition();
 
  //�����ο����������ļ�����
  Map<String , String> original = new HashMap<String, String>();
  original.put("basenames", "messages");
  original.put("useCodeAsDefaultMessage", "true");
  messageSourceDefinition.setBeanClass(ResourceBundleMessageSource.class);
  messageSourceDefinition.setPropertyValues(new MutablePropertyValues(original));
  //ע��
  beanFactory.registerBeanDefinition("ResourceBundleMessageSource",
    messageSourceDefinition);
  //��ȡ
  ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) applicationContext
    .getBean("ResourceBundleMessageSource");
                //����
  System.out.println(messageSource.getMessage("test", null, null));
 }

}