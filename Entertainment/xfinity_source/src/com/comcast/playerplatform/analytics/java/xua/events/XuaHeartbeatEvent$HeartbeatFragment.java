// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.events;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xua.events:
//            XuaHeartbeatEvent

public static class fragmentDuration
{

    private int downloadDuration;
    private int downloadLatency;
    private Integer fragmentDuration;
    private int fragmentSize;
    private int numberOfFragments;

    public int getDownloadDuration()
    {
        return downloadDuration;
    }

    public int getDownloadLatency()
    {
        return downloadLatency;
    }

    public Integer getFragmentDuration()
    {
        return fragmentDuration;
    }

    public int getFragmentSize()
    {
        return fragmentSize;
    }

    public int getNumberOfFragments()
    {
        return numberOfFragments;
    }

    public void setDownloadDuration(int i)
    {
        downloadDuration = i;
    }

    public void setDownloadLatency(int i)
    {
        downloadLatency = i;
    }

    public void setFragmentDuration(Integer integer)
    {
        fragmentDuration = integer;
    }

    public void setFragmentSize(int i)
    {
        fragmentSize = i;
    }

    public void setNumberOfFragments(int i)
    {
        numberOfFragments = i;
    }

    public (int i, int j, int k, int l, Integer integer)
    {
        numberOfFragments = i;
        fragmentSize = j;
        downloadLatency = k;
        downloadDuration = l;
        fragmentDuration = integer;
    }
}
