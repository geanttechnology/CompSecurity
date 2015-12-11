// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;


public class FragmentInfo
{

    private long downloadDuration;
    private long downloadLatency;
    private long fragmentDuration;
    private long fragmentSize;
    private int numberOfFragments;

    public FragmentInfo()
    {
        numberOfFragments = 0;
        fragmentSize = 0L;
        downloadLatency = 0L;
        downloadDuration = 0L;
        fragmentDuration = 0L;
    }

    public void addFragment(long l, long l1, long l2)
    {
        downloadDuration = downloadDuration + l;
        fragmentSize = fragmentSize + l2;
        fragmentDuration = fragmentDuration + l1;
        numberOfFragments = numberOfFragments + 1;
    }

    public long getDownloadDuration()
    {
        return downloadDuration;
    }

    public long getDownloadLatency()
    {
        return downloadLatency;
    }

    public long getFragmentDuration()
    {
        return fragmentDuration;
    }

    public long getFragmentSize()
    {
        return fragmentSize;
    }

    public int getNumberOfFragments()
    {
        return numberOfFragments;
    }

    public void reset()
    {
        if (numberOfFragments == 0)
        {
            return;
        } else
        {
            numberOfFragments = 0;
            fragmentSize = 0L;
            downloadLatency = 0L;
            downloadDuration = 0L;
            fragmentDuration = 0L;
            return;
        }
    }
}
