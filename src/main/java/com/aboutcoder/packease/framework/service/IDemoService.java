package com.aboutcoder.packease.framework.service;


import com.aboutcoder.packease.framework.domain.po.GuideBasic;

/**
 * <Description>
 * Copyright © 2006-2016 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 1/13/16 1:37 AM<br />
 * @description <br />
 */
public interface IDemoService {
    /**
     * 获取示例数据
     *
     * @return
     */
    String getTextString();

    /**
     * 获取DB数据
     *
     * @param id
     * @return
     */
    GuideBasic getDbRows(Integer id);
}
