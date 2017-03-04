package com.aboutcoder.packease.framework.component.akka;

import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <Description>
 * Copyright © 2006-2017 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 03/03/2017 11:39 AM<br />
 * @description
 *
 * An Akka Extension to provide access to Spring managed Actor Beans<br />
 */
@Component("springAkkaExtension")
public class SpringAkkaExtension implements Extension, ApplicationContextAware {

    /**
     * Spring application context.
     */
    private ApplicationContext applicationContext;

    /**
     * Create a Props for the specified actorBeanName using the SpringActorProducer
     *
     * @see SpringActorProducer
     * @param actorBeanName
     * The name of the actor bean to create Props for.
     * @param args
     * The arguments which use to initial actor.
     * @return a Props that will create the named actor bean using Spring
     */
    public Props props(String actorBeanName, Object... args) {
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
