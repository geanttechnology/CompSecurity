// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VideoAuthToken
{

    private String issueTime;
    private String keyName;
    private String opaqueUserID;
    private String rawData;
    private String requestorID;
    private String resourceID;
    private String titleID;
    private String ttl;
    private String value;

    public VideoAuthToken()
    {
    }

    public String getIssueTime()
    {
        return issueTime;
    }

    public String getKeyName()
    {
        return keyName;
    }

    public String getOpaqueUserID()
    {
        return opaqueUserID;
    }

    public String getRawData()
    {
        return rawData;
    }

    public String getRequestorID()
    {
        return requestorID;
    }

    public String getResourceID()
    {
        return resourceID;
    }

    public String getTitleID()
    {
        return titleID;
    }

    public String getTtl()
    {
        return ttl;
    }

    public String getValue()
    {
        return value;
    }

    public void setIssueTime(String s)
    {
        issueTime = s;
    }

    public void setKeyName(String s)
    {
        keyName = s;
    }

    public void setOpaqueUserID(String s)
    {
        opaqueUserID = s;
    }

    public void setRawData(String s)
    {
        rawData = s;
    }

    public void setRequestorID(String s)
    {
        requestorID = s;
    }

    public void setResourceID(String s)
    {
        resourceID = s;
    }

    public void setTitleID(String s)
    {
        titleID = s;
    }

    public void setTtl(String s)
    {
        ttl = s;
    }

    public void setValue(String s)
    {
        value = s;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("resourceID", resourceID).append("titleId", titleID).append("requestorID", requestorID).append("issueTime", issueTime).append("ttl", ttl).append("opaqueUserID", opaqueUserID).append("keyName", keyName).append("value", value).toString();
    }
}
