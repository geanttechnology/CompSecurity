// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.orbit;

import com.shazam.b.b;

public interface OrbitErrorAnalytics
{

    public static final OrbitErrorAnalytics NO_OP = (OrbitErrorAnalytics)b.a(com/shazam/android/analytics/orbit/OrbitErrorAnalytics);

    public abstract void sendBadServerResponse(String s, int i);

    public abstract void sendInternalServerError(String s, String s1);

}
