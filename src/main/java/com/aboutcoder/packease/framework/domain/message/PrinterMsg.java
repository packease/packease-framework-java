package com.aboutcoder.packease.framework.domain.message;

/**
 * <Description>
 * Copyright © 2006-2017 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 03/03/2017 4:23 PM<br />
 * @description <br />
 */
public final class PrinterMsg {
    /**
     * Number parameter
     */
    private final Integer number;

    /**
     * String parameter
     */
    private final String str;

    public PrinterMsg(Integer number, String str) {
        this.number = number;
        this.str = str;
    }

    /**
     * Get number <br>
     *
     * @return Returns the number. <br>
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Get str <br>
     *
     * @return Returns the str. <br>
     */
    public String getStr() {
        return str;
    }
}
