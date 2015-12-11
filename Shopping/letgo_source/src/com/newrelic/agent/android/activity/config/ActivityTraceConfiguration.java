// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.activity.config;


public class ActivityTraceConfiguration
{

    private int maxTotalTraceCount;

    public ActivityTraceConfiguration()
    {
    }

    public static ActivityTraceConfiguration defaultActivityTraceConfiguration()
    {
        ActivityTraceConfiguration activitytraceconfiguration = new ActivityTraceConfiguration();
        activitytraceconfiguration.setMaxTotalTraceCount(1);
        return activitytraceconfiguration;
    }

    public int getMaxTotalTraceCount()
    {
        return maxTotalTraceCount;
    }

    public void setMaxTotalTraceCount(int i)
    {
        maxTotalTraceCount = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ActivityTraceConfiguration{maxTotalTraceCount=").append(maxTotalTraceCount).append('}').toString();
    }
}
