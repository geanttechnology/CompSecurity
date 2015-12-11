// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;


public class DetailedRequestStatus
{

    private final Integer statusCode;
    private final String statusMessage;

    public DetailedRequestStatus(Integer integer, String s)
    {
        statusCode = integer;
        statusMessage = s;
    }

    public Integer getStatusCode()
    {
        return statusCode;
    }

    public String getStatusMessage()
    {
        return statusMessage;
    }

    public String toString()
    {
        return (new StringBuilder()).append(String.valueOf(statusCode)).append(" ").append(statusMessage).toString();
    }
}
