package com.aboutcoder.ssm.service.impl;

import com.aboutcoder.ssm.service.IDemoService;
import org.springframework.stereotype.Service;

/**
 * <Description>
 * Copyright © 2006-2016 Tuniu Inc. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 1/13/16 1:38 AM<br />
 * @description <br />
 */
@Service
public class DemoServiceImpl implements IDemoService {
    /**
     * 获取示例数据
     *
     * @return
     */
    @Override
    public String getTextString() {
        return "示例数据";
    }
}
