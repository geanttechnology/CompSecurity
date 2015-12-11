// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaFragmentWarningValue extends AbstractXuaValue
{

    private int downloadDuration;
    private int downloadLatency;
    private int fragmentDuration;
    private int fragmentSize;
    private String fragmentUrl;

    public XuaFragmentWarningValue(String s, int i, int j, int k, int l)
    {
        fragmentUrl = s;
        fragmentSize = i;
        downloadLatency = j;
        downloadDuration = k;
        fragmentDuration = l;
    }

    public int getDownloadDuration()
    {
        return downloadDuration;
    }

    public int getDownloadLatency()
    {
        return downloadLatency;
    }

    public int getFragmentDuration()
    {
        return fragmentDuration;
    }

    public int getFragmentSize()
    {
        return fragmentSize;
    }

    public String getFragmentUrl()
    {
        return fragmentUrl;
    }

    public void setDownloadDuration(int i)
    {
        downloadDuration = i;
    }

    public void setDownloadLatency(int i)
    {
        downloadLatency = i;
    }

    public void setFragmentDuration(int i)
    {
        fragmentDuration = i;
    }

    public void setFragmentSize(int i)
    {
        fragmentSize = i;
    }

    public void setFragmentUrl(String s)
    {
        fragmentUrl = s;
    }
}
