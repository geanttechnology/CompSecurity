// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import com.crashlytics.android.Crashlytics;

public class CrashlyticsService
{

    public CrashlyticsService()
    {
    }

    public void log(String s)
    {
        Crashlytics.log(s);
    }
}
