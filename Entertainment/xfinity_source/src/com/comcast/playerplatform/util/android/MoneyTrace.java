// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;

import java.util.Random;

public class MoneyTrace
{

    private Random rand;
    private String traceId;

    public MoneyTrace(String s)
    {
        rand = new Random();
        traceId = s;
    }

    public String generateHttpHeaderValue()
    {
        long l1 = rand.nextLong();
        long l = l1;
        if (l1 < 0L)
        {
            l = -l1;
        }
        return (new StringBuilder()).append("trace-id=").append(traceId).append(";").append("parent-id").append("=").append(l).append(";").append("span-id").append("=").append(l).toString();
    }

    public String getHttpHeader()
    {
        return "X-MoneyTrace";
    }

    public String getTraceId()
    {
        return traceId;
    }
}
