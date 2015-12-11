// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.analytics;

import com.shazam.android.analytics.session.FlurrySessionAnalytics;
import com.shazam.android.analytics.session.SessionAnalytics;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.t.a.a;

public class FlurrySessionActivityAspect extends b
{

    private final SessionAnalytics sessionAnalytics;

    public FlurrySessionActivityAspect()
    {
        a a1 = new a(com.shazam.i.b.n.b.Q());
        com.shazam.android.t.a.b.a a2 = new com.shazam.android.t.a.b.a();
        a2.a = "SZ5ULUJ49GBIMBBQIPDQ";
        this(((SessionAnalytics) (new FlurrySessionAnalytics(a1, new com.shazam.android.t.a.b(a2, (byte)0)))));
    }

    public FlurrySessionActivityAspect(SessionAnalytics sessionanalytics)
    {
        sessionAnalytics = sessionanalytics;
    }

    public void onStart(com.shazam.android.aspects.c.a.a a1)
    {
        sessionAnalytics.startSession(a1);
    }

    public void onStop(com.shazam.android.aspects.c.a.a a1)
    {
        sessionAnalytics.stopSession(a1);
    }
}
