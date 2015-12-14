// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;


public class AdLog
{

    String event;
    String logUrl;
    String source;

    public AdLog(String s, String s1, String s2)
    {
        logUrl = s;
        source = s1;
        event = s2;
    }

    public String getEvent()
    {
        return event;
    }

    public String getLogUrl()
    {
        return logUrl;
    }

    public String getSource()
    {
        return source;
    }
}
