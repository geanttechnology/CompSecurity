// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol;


public class ServerError
{

    private Integer a;
    private String b;

    public ServerError()
    {
    }

    public Integer getCode()
    {
        return a;
    }

    public String getReason()
    {
        return b;
    }

    public void setCode(Integer integer)
    {
        a = integer;
    }

    public void setReason(String s)
    {
        b = s;
    }

    public String toString()
    {
        return (new StringBuilder("ServerError [code=")).append(a).append(", reason=").append(b).append("]").toString();
    }
}
