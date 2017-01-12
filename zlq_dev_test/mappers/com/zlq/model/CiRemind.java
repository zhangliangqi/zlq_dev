package com.zlq.model;

import java.math.BigDecimal;
import java.util.Date;

public class CiRemind {
    private BigDecimal id;

    private String remindContext;

    private Date remindTime;

    private String remindContractno;

    private String remindSyskey;

    private String remindCollector;

    private Date disposeTime;

    private String disposeCreator;

    private String isDispose;

    private String creator;

    private Date creatorTime;

    private Date updateTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRemindContext() {
        return remindContext;
    }

    public void setRemindContext(String remindContext) {
        this.remindContext = remindContext == null ? null : remindContext.trim();
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public String getRemindContractno() {
        return remindContractno;
    }

    public void setRemindContractno(String remindContractno) {
        this.remindContractno = remindContractno == null ? null : remindContractno.trim();
    }

    public String getRemindSyskey() {
        return remindSyskey;
    }

    public void setRemindSyskey(String remindSyskey) {
        this.remindSyskey = remindSyskey == null ? null : remindSyskey.trim();
    }

    public String getRemindCollector() {
        return remindCollector;
    }

    public void setRemindCollector(String remindCollector) {
        this.remindCollector = remindCollector == null ? null : remindCollector.trim();
    }

    public Date getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(Date disposeTime) {
        this.disposeTime = disposeTime;
    }

    public String getDisposeCreator() {
        return disposeCreator;
    }

    public void setDisposeCreator(String disposeCreator) {
        this.disposeCreator = disposeCreator == null ? null : disposeCreator.trim();
    }

    public String getIsDispose() {
        return isDispose;
    }

    public void setIsDispose(String isDispose) {
        this.isDispose = isDispose == null ? null : isDispose.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}