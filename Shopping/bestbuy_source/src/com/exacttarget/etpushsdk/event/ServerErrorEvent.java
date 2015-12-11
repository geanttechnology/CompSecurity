// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import java.io.Serializable;

public class ServerErrorEvent
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String documentation;
    private Integer errorcode;
    private String message;

    public ServerErrorEvent()
    {
    }

    public ServerErrorEvent(String s)
    {
        message = s;
    }

    public ServerErrorEvent(String s, Integer integer)
    {
        message = s;
        errorcode = integer;
    }

    public String getDocumentation()
    {
        return documentation;
    }

    public Integer getErrorcode()
    {
        return errorcode;
    }

    public String getMessage()
    {
        return message;
    }

    public void setDocumentation(String s)
    {
        documentation = s;
    }

    public void setErrorcode(Integer integer)
    {
        errorcode = integer;
    }

    public void setMessage(String s)
    {
        message = s;
    }
}
