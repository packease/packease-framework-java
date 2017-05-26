package com.aboutcoder.packease.framework.component.akka;

import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;

/**
 * <Description>
 * Copyright © 2006-2017 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 03/03/2017 11:12 AM<br />
 * @description
 *
 * The application configuration.<br />
 */
@Configuration
public class AppConfiguration {

    /**
     * the path of akka configuration file.
     */
    private final String configPath = "/config/akka.conf";

    /**
     * the name of global ActorSystem instance.
     */
    private final String actorSystemName = "ActorSystem-PE_framework_java";

    /**
     * the application context is been injected.
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Actor system singleton for this application.
     *
     * @return
     */
    @Bean(name = "actorSystem", destroyMethod = "shutdown")
    @Scope(value = "singleton")
    public ActorSystem actorSystem() {
        if (new ClassPathResource(configPath).exists()) {
            return ActorSystem.create(actorSystemName, ConfigFactory.load(configPath));
        }
        return ActorSystem.create(actorSystemName, ConfigFactory.load());
    }
}
