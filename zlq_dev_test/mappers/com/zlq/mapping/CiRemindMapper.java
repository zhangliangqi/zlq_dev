package com.zlq.mapping;

import com.zlq.model.CiRemind;
import java.math.BigDecimal;
import java.util.List;

public interface CiRemindMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(CiRemind record);

    CiRemind selectByPrimaryKey(BigDecimal id);

    List<CiRemind> selectAll();

    int updateByPrimaryKey(CiRemind record);
}