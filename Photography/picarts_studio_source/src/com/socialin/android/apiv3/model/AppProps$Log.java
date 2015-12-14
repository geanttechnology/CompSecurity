// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


public final class timeStampUnit
{

    public int eventsBatchTime;
    public boolean logInfo;
    public long sessionTimeOut;
    public int timeStampUnit;

    public ()
    {
        logInfo = false;
        sessionTimeOut = 15000L;
        eventsBatchTime = 0x493e0;
        timeStampUnit = 1000;
    }
}
