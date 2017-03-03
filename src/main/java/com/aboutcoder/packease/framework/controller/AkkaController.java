package com.aboutcoder.packease.framework.controller;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * <Description>
 * Copyright © AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 06/01/2017 5:45 PM<br />
 * @description <br />
 */
public class AkkaController {
    public static void main(String[] args) {
        System.out.println("------Begin---------");

        ActorSystem actorSystem = ActorSystem.create("AkkaController-actorSystem");
        ActorRef bob = actorSystem.actorOf(Props.create(Greeter.class, "Bob", "Howya doing"));
        ActorRef alice = actorSystem.actorOf(Greeter.props("Alice", "Happy to meet you"));

        bob.tell(new Greet(alice), ActorRef.noSender());
        alice.tell(new Greet(bob), ActorRef.noSender());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.println("------End---------");
    }

    /**
     * Message for actor
     */
    private static class Greet {
        private final ActorRef actorRef;

        public Greet(ActorRef actorRef) {
            this.actorRef = actorRef;
        }
    }

    /**
     * Delegate object for transfer messages
     */
    private static Object askName = new Object();

    /**
     * Message for actor
     */
    private static class TellName {
        private final String name;

        public TellName(String name) {
            this.name = name;
        }
    }

    private static class Greeter extends UntypedActor {
        private final String myName;

        private final String greeting;

        public Greeter(String myName, String greeting) {
            this.myName = myName;
            this.greeting = greeting;
        }

        /**
         * Create an actor instance with actor class ref.
         *
         * @param name
         * @param greeting
         * @return
         */
        public static Props props(String name, String greeting) {
            return Props.create(Greeter.class, name, greeting);
        }

        /**
         * Deal with the message when receiving from outer actors
         *
         * @param o
         * @throws Throwable
         */
        @Override
        public void onReceive(Object o) {
            if (o instanceof Greet) {
                ((Greet) o).actorRef.tell(askName, self());
            } else if (o == askName) {
                getSender().tell(new TellName(myName), self());
            } else if (o instanceof TellName) {
                System.out.println(greeting + ", " + ((TellName)o).name);
            }
        }
    }
}
