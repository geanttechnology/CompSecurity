// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;


public class PowerStatusChangedEvent
{

    public static final int BATTERY_LOW = 0;
    public static final int BATTERY_OK = 1;
    private int status;

    public PowerStatusChangedEvent(int i)
    {
        status = i;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int i)
    {
        status = i;
    }
}
