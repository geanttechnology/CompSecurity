// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;


public class EnvironmentInformation
{

    private long diskAvailable[];
    private long memoryUsage;
    private String networkStatus;
    private String networkWanType;
    private int orientation;

    public EnvironmentInformation()
    {
    }

    public EnvironmentInformation(long l, int i, String s, String s1, long al[])
    {
        memoryUsage = l;
        orientation = i;
        networkStatus = s;
        networkWanType = s1;
        diskAvailable = al;
    }

    public long[] getDiskAvailable()
    {
        return diskAvailable;
    }

    public long getMemoryUsage()
    {
        return memoryUsage;
    }

    public String getNetworkStatus()
    {
        return networkStatus;
    }

    public String getNetworkWanType()
    {
        return networkWanType;
    }

    public int getOrientation()
    {
        return orientation;
    }

    public void setDiskAvailable(long al[])
    {
        diskAvailable = al;
    }

    public void setMemoryUsage(long l)
    {
        memoryUsage = l;
    }

    public void setNetworkStatus(String s)
    {
        networkStatus = s;
    }

    public void setNetworkWanType(String s)
    {
        networkWanType = s;
    }

    public void setOrientation(int i)
    {
        orientation = i;
    }
}
