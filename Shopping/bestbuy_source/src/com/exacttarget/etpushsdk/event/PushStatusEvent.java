// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;


public class PushStatusEvent
{

    private boolean isPushEnabled;

    public PushStatusEvent(boolean flag)
    {
        isPushEnabled = flag;
    }

    public boolean isPushEnabled()
    {
        return isPushEnabled;
    }
}
