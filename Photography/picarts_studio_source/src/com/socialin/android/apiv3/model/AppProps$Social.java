// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


public final class 
{

    public int contactChangeDiff;
    public int contactRefreshIntervalDays;
    public int contentRefreshTime;

    public final long getIntervalInMillis()
    {
        return (long)(contactRefreshIntervalDays * 24 * 60 * 60 * 1000);
    }

    public ()
    {
    }
}
