// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public class Status
{

    String code;
    String message;
    String status;

    public Status()
    {
        status = "";
        message = "";
        code = "";
    }

    public String getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public String getStatus()
    {
        return status;
    }

    public void setCode(String s)
    {
        code = s;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public void setStatus(String s)
    {
        status = s;
    }

    public String toString()
    {
        return (new StringBuilder("Status [status=")).append(status).append(", message=").append(message).append(", code=").append(code).append("]").toString();
    }
}
