package com.aboutcoder.packease.framework.component.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.event.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * <Description>
 * Copyright © 2006-2017 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 03/03/2017 11:49 AM<br />
 * @description <br />
 */
@Component
public class ActorGenerator {

    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringAkkaExt springAkkaExt;

    /**
     * Actor creator wrapper.
     *
     * @param actorBeanName
     * @param actorName
     * @param args
     * @return
     */
    public ActorRef create(String actorBeanName, String actorName, Object... args) {
        String uniqueActorName = buildUniqueActorName(actorName);
        ActorRef actorRef = actorSystem.actorOf(springAkkaExt.props(actorBeanName, args), uniqueActorName);
        actorSystem.log().debug("Create a new actor named:" + uniqueActorName);
        return actorRef;
    }

    /**
     * Actor creator wrapper.
     *
     * @param actorBeanName
     * @param args
     * @return
     */
    public ActorRef create(String actorBeanName, Object... args) {
        String uniqueActorName = buildUniqueActorName(actorBeanName);
        ActorRef actorRef = actorSystem.actorOf(springAkkaExt.props(actorBeanName, args), uniqueActorName);
        actorSystem.log().debug("Create a new actor named:" + uniqueActorName);
        return actorRef;
    }

    /**
     * Generate an unique actor name for creating.
     *
     * @param actorNamePrefix
     * @return
     */
    private String buildUniqueActorName(String actorNamePrefix) {
        String uuid = UUID.randomUUID().toString();
        String uuidStr = uuid.replace("-", "");
        StringBuffer stringBuffer = new StringBuffer(actorNamePrefix).append("-").append(uuidStr);
        return stringBuffer.toString();
    }
}
