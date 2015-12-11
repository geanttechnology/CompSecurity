// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.g.b;

import com.shazam.android.analytics.event.BeaconEventAnalytics;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.ViewTraversingEventAnalytics;

public final class a
{

    private static BeaconEventAnalytics a;

    public static EventAnalytics a()
    {
        if (a == null)
        {
            a = new BeaconEventAnalytics(com.shazam.i.b.k.a.a());
        }
        return a;
    }

    public static EventAnalyticsFromView b()
    {
        return new ViewTraversingEventAnalytics(new EventAnalytics[] {
            a()
        });
    }
}
