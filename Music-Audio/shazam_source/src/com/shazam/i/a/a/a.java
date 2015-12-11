// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.a.a;

import com.shazam.android.analytics.orbit.BeaconingOrbitErrorAnalytics;
import com.shazam.android.analytics.orbit.OrbitErrorAnalytics;

public final class a
{

    public static OrbitErrorAnalytics a()
    {
        return new BeaconingOrbitErrorAnalytics(com.shazam.i.b.g.b.a.a());
    }
}
