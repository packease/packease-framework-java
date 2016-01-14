package com.aboutcoder.ssm.service.impl;

import com.aboutcoder.ssm.domain.po.GuideBasic;
import com.aboutcoder.ssm.persistence.GuideBasicMapper;
import com.aboutcoder.ssm.service.IDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description>
 * Copyright © 2006-2016 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 1/13/16 1:38 AM<br />
 * @description <br />
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Resource
    private GuideBasicMapper guideBasicMapper;

    /**
     * 获取示例数据
     *
     * @return
     */
    @Override
    public String getTextString() {
        return "示例数据";
    }

    /**
     * 获取DB数据
     *
     * @param guideId
     * @return
     */
    @Override
    public GuideBasic getDbRows(Integer guideId) {
        GuideBasic guideBasic = guideBasicMapper.selectByPrimaryKey(guideId);
        return guideBasic;
    }
}
