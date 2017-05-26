package com.aboutcoder.packease.framework.component.akka;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * <Description>
 * Copyright © 2006-2017 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 03/03/2017 11:31 AM<br />
 * @description
 *
 * An actor producer that lets Spring create the Actor instances<br />
 */
public class SpringActorProducer implements IndirectActorProducer {

    /**
     * Spring application context.
     */
    private final ApplicationContext applicationContext;

    /**
     * Actor bean name.
     */
    private final String actorBeanName;

    /**
     * Arguments for bean's initialization.
     */
    private final Object[] args;

    /**
     * Constructor with parameters.
     *
     * @param applicationContext
     * @param actorName
     * @param args
     */
    public SpringActorProducer(ApplicationContext applicationContext, String actorName, Object... args) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorName;
        this.args = args;
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName, args);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}
