package com.aboutcoder.ssm.persistence;


import com.aboutcoder.ssm.domain.po.GuideBasic;

/**
 * <Description>
 * Copyright © 2006-2016 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 1/13/16 5:11 PM<br />
 * @description <br />
 */
public interface GuideBasicMapper {
    /**
     * 查询数据
     *
     * @author chenjinlong 20160113
     * @param guideId
     * @return
     */
    GuideBasic selectByPrimaryKey(Integer guideId);
}
