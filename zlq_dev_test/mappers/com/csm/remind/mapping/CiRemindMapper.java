package com.csm.remind.mapping;

import com.csm.remind.entity.CiRemind;
import java.math.BigDecimal;
import java.util.List;

public interface CiRemindMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(CiRemind record);

    CiRemind selectByPrimaryKey(BigDecimal id);

    List<CiRemind> selectAll();

    int updateByPrimaryKey(CiRemind record);
}