package com.rocway.dependencyInjection;

import com.rocway.dependencyInjection.source.NewsProvider;
import com.rocway.dependencyInjection.source.impl.FXNewsListenerImpl;
import com.rocway.dependencyInjection.source.impl.FXNewsPersisterImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class CodeInject {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegister = new DefaultListableBeanFactory();
        BeanFactory beanFactory = bindViaCode(beanRegister);
        NewsProvider newsProvider = (NewsProvider) beanFactory.getBean("newsProvider");
        newsProvider.getAndPersistNews();
    }


    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        // 1. 创建Bean
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(NewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(FXNewsListenerImpl.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(FXNewsPersisterImpl.class);
        // 2. 将Bean定义注册到容器中
        registry.registerBeanDefinition("newsProvider", newsProvider);
        registry.registerBeanDefinition("newsListener", newsListener);
        registry.registerBeanDefinition("newsPersister", newsPersister);
        // 3. 指定依赖关系
        // 3.1 可以通过构造方法注入方式
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, newsListener);
        argumentValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argumentValues);
        // or 3.2 通过setter 方法注入方式
/*        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);*/
        // 绑定完成
        return (BeanFactory) registry;
    }
}
