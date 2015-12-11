// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;


public class BackgroundEvent
{

    private boolean inBackground;
    private long timeWentInBackground;

    public BackgroundEvent(boolean flag)
    {
        inBackground = flag;
        timeWentInBackground = -1L;
    }

    public BackgroundEvent(boolean flag, long l)
    {
        inBackground = flag;
        timeWentInBackground = l;
    }

    public long getTimeWentInBackground()
    {
        return timeWentInBackground;
    }

    public boolean isInBackground()
    {
        return inBackground;
    }
}
