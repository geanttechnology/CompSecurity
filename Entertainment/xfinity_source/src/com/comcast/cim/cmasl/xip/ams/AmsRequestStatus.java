// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip.ams;

import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;

public class AmsRequestStatus
{

    private final String errorMessage;
    private final Integer statusCode;

    public AmsRequestStatus(String s, Integer integer)
    {
        errorMessage = s;
        statusCode = integer;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public Integer getStatusCode()
    {
        return statusCode;
    }

    public DetailedRequestStatus toDetailedRequestStatus()
    {
        return new DetailedRequestStatus(statusCode, errorMessage);
    }
}
