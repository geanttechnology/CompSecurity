// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import android.util.DisplayMetrics;

public interface DeviceParams
{

    public abstract String getApplicationVersion();

    public abstract String getDeviceCountry();

    public abstract DisplayMetrics getDisplayMetrics();

    public abstract String getSearchDomainCountryCode();

    public abstract String getUserAgent();
}
