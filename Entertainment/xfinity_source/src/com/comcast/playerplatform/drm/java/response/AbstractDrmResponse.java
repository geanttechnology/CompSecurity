// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.response;


public abstract class AbstractDrmResponse
{

    protected String messageId;
    protected String notOnOrAfter;
    protected boolean parsed;
    protected String rawXml;
    protected String status;
    protected String token;

    public String getMessageId()
    {
        return messageId;
    }

    public String getNotOnOrAfter()
    {
        return notOnOrAfter;
    }

    public String getRawXml()
    {
        return rawXml;
    }

    public String getStatus()
    {
        return status;
    }

    public String getToken()
    {
        return token;
    }

    public boolean isParsed()
    {
        return parsed;
    }

    public void setNotOnOrAfter(String s)
    {
        notOnOrAfter = s;
    }

    public void setParsed(boolean flag)
    {
        parsed = flag;
    }

    public void setRawXml(String s)
    {
        rawXml = s;
    }

    public void setStatus(String s)
    {
        status = s;
    }

    public void setToken(String s)
    {
        token = s;
    }
}
