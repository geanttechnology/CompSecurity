// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.common;


public class MachineMeasurements
{

    private final float memoryUsage;

    public MachineMeasurements()
    {
        memoryUsage = 0.0F;
    }

    public MachineMeasurements(float f)
    {
        memoryUsage = f;
    }

    public float getMemoryUsage()
    {
        return memoryUsage;
    }
}
