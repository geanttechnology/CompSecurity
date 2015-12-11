// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaMediaOpenedValue extends AbstractXuaValue
{

    private Long latency;
    private String manifestUrl;
    private long position;

    public XuaMediaOpenedValue(long l, Long long1, String s)
    {
        position = l;
        latency = long1;
        manifestUrl = s;
    }

    public Long getLatency()
    {
        return latency;
    }

    public String getManifestUrl()
    {
        return manifestUrl;
    }

    public long getPosition()
    {
        return position;
    }

    public void setLatency(Long long1)
    {
        latency = long1;
    }

    public void setManifestUrl(String s)
    {
        manifestUrl = s;
    }

    public void setPosition(long l)
    {
        position = l;
    }
}
