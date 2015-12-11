// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.trigger;


public class NextPageTrigger
{

    protected boolean triggered;

    public NextPageTrigger()
    {
        triggered = false;
    }

    public boolean isTriggered()
    {
        return triggered;
    }

    public void setTriggered(boolean flag)
    {
        triggered = flag;
    }
}
