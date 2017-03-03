package com.aboutcoder.packease.framework.actor;

import akka.actor.UntypedActor;
import com.aboutcoder.packease.framework.domain.message.PrinterMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <Description>
 * Copyright © 2006-2017 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 03/03/2017 2:40 PM<br />
 * @description <br />
 */
@Scope("prototype")
@Component
public class PrinterActor extends UntypedActor {
    private final static Logger LOGGER = LoggerFactory.getLogger(PrinterActor.class);

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PrinterMsg) {
            PrinterMsg msg = (PrinterMsg) message;
            System.out.println("Received called message:");
            System.out.println(msg.getNumber() + "#" + msg.getStr());
        } else if (message instanceof String) {
            System.out.println("Received called message:");
            System.out.println("message = [" + message.toString() + "]");
        } else {
            unhandled(message);
        }
        getContext().stop(getSelf());
    }


}
